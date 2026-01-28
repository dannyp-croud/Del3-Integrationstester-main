package systementor.integrationApiTestDemo.model;
import java.util.List;
import java.util.Map;

public class Country {

    private String commonName;
    private String officialName;
    private String region;
    private String subregion;
    private Map<String, String> languages;
    private List<String> borders;
    private long population;

    public Country() {}

    public Country(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {

        this.commonName = commonName;
    }

    public String getOfficialName() {

        return officialName;
    }

    public void setOfficialName(String officialName) {

        this.officialName = officialName;
    }

    public String getRegion() {

        return region;
    }

    public void setRegion(String region) {

        this.region = region;
    }

    public String getSubregion() {

        return subregion;
    }

    public void setSubregion(String subregion) {

        this.subregion = subregion;
    }

    public Map<String, String> getLanguages() {

        return languages;
    }

    public void setLanguages(Map<String, String> languages) {

        this.languages = languages;
    }

    public List<String> getBorders() {

        return borders;
    }

    public void setBorders(List<String> borders) {

        this.borders = borders;
    }

    public long getPopulation() {

        return population;
    }

    public void setPopulation(long population) {

        this.population = population;
    }
}