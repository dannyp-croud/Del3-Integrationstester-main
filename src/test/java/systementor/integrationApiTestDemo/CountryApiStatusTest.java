package systementor.integrationApiTestDemo;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountryApiStatusTest {

    // G-krav

    @Test
    void allCountriesEndpointShouldReturn200() {
        WebClient client = WebClient.create("https://restcountries.com");

        var response = client.get()
                .uri("/v3.1/all?fields=name")
                .exchangeToMono(r -> r.toEntity(String.class))
                .block();

        if (response == null) throw new AssertionError();
        assertEquals(200, response.getStatusCode().value());

        //assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}