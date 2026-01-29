package DannyPhan.Del3Integrationstest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import DannyPhan.Del3Integrationstest.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final String BASE_URL = "https://fakestoreapi.com";
    private final WebClient webClient;

    public ProductService() {
        this.webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public List<Product> getAllProductTitles() {
        var response = webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(Map[].class)
                .block();

        if (response == null) throw new AssertionError();

        return Arrays.stream(response)
                .map(productMap -> new Product((String) productMap.get("title")))
                .collect(Collectors.toList());
    }

    public Product getProductById(int id) {
        var response = webClient.get()
                .uri("/products/" + id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (response == null) throw new AssertionError();

        Product product = new Product();
        product.setId((Integer) response.get("id"));
        product.setTitle((String) response.get("title"));
        product.setPrice(((Number) response.get("price")).doubleValue());
        product.setDescription((String) response.get("description"));
        product.setCategory((String) response.get("category"));
        product.setImage((String) response.get("image"));

        return product;

    }
}