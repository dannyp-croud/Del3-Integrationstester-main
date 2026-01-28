package systementor.integrationApiTestDemo.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import systementor.integrationApiTestDemo.model.Country;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private static final String BASE_URL = "https://restcountries.com";

    private final WebClient webClient;


    //Här kopplar vi upp oss till webbklienten
    public CountryService() {
        this.webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public List<Country> getAllCountryNames() {

        //URI är att vi säger att vi lägger till det på slutet av vår URL som ett sätt att säga till koden var vi vill hämta data
        var response = webClient.get()
                .uri("/v3.1/all?fields=name")
                .retrieve()
                .bodyToMono(Map[].class)
                .block();

        if (response == null) throw new AssertionError();
        return Arrays.stream(response).map(countryMap -> (Map) countryMap.get("name"))
                .map(name -> {
                    String commonName = (String) name.get("common");
                    return new Country(commonName);
                })
                .collect(Collectors.toList());
    }

    //Här måste man lägga in en sträng på det landet man vill hämta info ifrån t.ex. Sweden, Latvia, Germany
    public Country getCountryByName(String requestedName) {

        var response = webClient.get()
                .uri("/v3.1/name/" + requestedName)
                .retrieve()
                .bodyToMono(Map[].class)
                .block();

        if (response == null) throw new AssertionError();
        var data = response[0];

        Country country = new Country();

        //Här mappas upp all data i JSON svaret
        var name = (Map) data.get("name");
        country.setCommonName((String) name.get("common"));
        country.setOfficialName((String) name.get("official"));

        country.setRegion((String) data.get("region"));
        country.setSubregion((String) data.get("subregion"));
        country.setPopulation(((Number) data.get("population")).longValue());

        country.setLanguages((Map<String, String>) data.get("languages"));
        country.setBorders((List<String>) data.get("borders"));

        return country;
    }
}