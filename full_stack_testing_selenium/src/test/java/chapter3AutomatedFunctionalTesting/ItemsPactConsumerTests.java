package chapter3AutomatedFunctionalTesting;


import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import chapter3AutomatedFunctionalTesting.models.Category;
import chapter3AutomatedFunctionalTesting.models.Product;
import chapter3AutomatedFunctionalTesting.models.Usertype;
import chapter3AutomatedFunctionalTesting.utilities.PIMService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

@ExtendWith(PactConsumerTestExt.class)
public class ItemsPactConsumerTests {

    @Pact(consumer = "Order Service", provider = "PIMService")
    public RequestResponsePact getAvailableProductDetails(PactDslWithProvider builder){
        return builder
                .given("Products are available")
                .uponReceiving("Get products list")
                .method("GET")
                .path("https://automationexercise.com/api/productsList")
                .willRespondWith()
                .status(200)
                .headers(Map.of("Content-Type", "application/json; charset=utf-8"))
                .body(PactDslJsonArray.arrayMinLike(1)
                        .object()
                            .stringType("id", "1")
                            .stringType("name", "Top")
                            .stringType("price", "100")
                            .stringType("brand", "Defacto")
                            .object("category")
                                .stringType("userType", "women")
                                .stringType("category", "women")
                            .closeObject()
                        .closeObject()
                )
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "getAvailableProductDetails")
    void getProductsWhenTheyAreAvailable(MockServer mockServer){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(mockServer.getUrl())
                .build();

        PIMService pimService = new PIMService(restTemplate);
        List<Product> items = pimService.getAvailableProductDetails();

        Usertype usertype = new Usertype("women");
        Category category = new Category("women", usertype);
        Product product1 = new Product("1", "Top", "100", "Defacto", category );
        List<Product> expectedItems = List.of(product1);

        assertEquals(expectedItems, items);

    }
}
