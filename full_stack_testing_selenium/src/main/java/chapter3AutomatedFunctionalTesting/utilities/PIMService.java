package chapter3AutomatedFunctionalTesting.utilities;
import chapter3AutomatedFunctionalTesting.models.Category;
import chapter3AutomatedFunctionalTesting.models.Product;
import chapter3AutomatedFunctionalTesting.models.Usertype;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PIMService {
    private final RestTemplate restTemplate;

    public PIMService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getAvailableProductDetails() {
        Usertype usertype = new Usertype("women");
        Category category = new Category("women", usertype);
        Product product1 = new Product("1", "Top", "100", "Defacto", category );
        // Logic to call the mock server and parse response into List<Product>
        return List.of(product1);
    }
}
