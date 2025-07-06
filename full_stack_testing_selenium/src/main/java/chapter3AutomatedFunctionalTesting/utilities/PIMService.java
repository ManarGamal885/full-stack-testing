package chapter3AutomatedFunctionalTesting.utilities;
import chapter3AutomatedFunctionalTesting.models.Category;
import chapter3AutomatedFunctionalTesting.models.Product;
import chapter3AutomatedFunctionalTesting.models.Usertype;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

public class PIMService {
    private final RestTemplate restTemplate;

    public PIMService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getAvailableProductDetails() {
        return List.of(Objects.requireNonNull(restTemplate.getForObject("/api/productsList", Product[].class)));
    }
}
