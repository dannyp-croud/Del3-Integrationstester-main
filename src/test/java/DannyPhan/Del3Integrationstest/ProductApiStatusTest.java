package DannyPhan.Del3Integrationstest;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductApiStatusTest {

    // G-krav

    @Test
    void allProductsEndpointShouldReturn200() {
        WebClient client = WebClient.create("https://fakestoreapi.com");

        var response = client.get()
                .uri("/products/")
                .exchangeToMono(r -> r.toEntity(String.class))
                .block();

        if (response == null) throw new AssertionError();
        assertEquals(200, response.getStatusCode().value());

        // Nedan kod kan användas till fördel att checka av att returnerad statuskod börjar på 2xx
        //assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}