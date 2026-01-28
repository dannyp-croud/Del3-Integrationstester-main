package systementor.integrationApiTestDemo;
import org.junit.jupiter.api.Test;
import systementor.integrationApiTestDemo.model.Country;
import systementor.integrationApiTestDemo.service.CountryService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountryServiceTest {

    // VG-krav
    private final CountryService countryService = new CountryService();

    @Test
    void getAllCountryNames_returnsCorrectNumberOfCountries() {

        List<Country> countries = countryService.getAllCountryNames();

        assertNotNull(countries);
        assertEquals(250 , countries.size());

    }

    @Test
    void getCountryByName_latvia_containsCorrectMappedData() {

        Country latvia = countryService.getCountryByName("latvia");

        assertNotNull(latvia);

        assertEquals("Latvia", latvia.getCommonName());
        assertEquals("Republic of Latvia", latvia.getOfficialName());
        assertEquals("Europe", latvia.getRegion());
        assertEquals("Northern Europe", latvia.getSubregion());

        assertEquals(1829000, latvia.getPopulation());

        assertEquals(
                Map.of("lav", "Latvian"),
                latvia.getLanguages()
        );

        assertEquals(
                List.of("BLR", "EST", "LTU", "RUS"),
                latvia.getBorders()
        );
    }
}