package systementor.integrationApiTestDemo;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CountryApiStructureTest {

    // VG-krav

    @Test
    void countryByNameShouldContainExpectedFields() {

        WebClient client = WebClient.create("https://restcountries.com");

        var response = client.get()
                .uri("/v3.1/name/sweden")
                .retrieve()
                .bodyToMono(Map[].class)
                .block();

        assertNotNull(response);
        assertTrue(response.length > 0);

        var country = response[0];

        assertTrue(country.containsKey("name"));
        assertTrue(country.containsKey("region"));
        assertTrue(country.containsKey("subregion"));
        assertTrue(country.containsKey("languages"));
        assertTrue(country.containsKey("population"));
        assertTrue(country.containsKey("borders"));
    }
}
