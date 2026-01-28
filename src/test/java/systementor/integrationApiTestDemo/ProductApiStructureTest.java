package systementor.integrationApiTestDemo;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductApiStructureTest {

    // VG-krav

    @Test
    void productByIdShouldContainExpectedFields() {

        WebClient client = WebClient.create("https://fakestoreapi.com");

        var response = client.get()
                .uri("/products/")
                .retrieve()
                .bodyToMono(Map[].class)
                .block();

        assertNotNull(response);
        assertTrue(response.length > 0);

        var product = response[0];

        assertTrue(product.containsKey("title"));
        assertTrue(product.containsKey("price"));
        assertTrue(product.containsKey("description"));
        assertTrue(product.containsKey("category"));
        assertTrue(product.containsKey("id"));
        assertTrue(product.containsKey("rating"));
    }
}
