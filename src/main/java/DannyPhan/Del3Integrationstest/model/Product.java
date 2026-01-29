package DannyPhan.Del3Integrationstest.model;
import java.util.List;
import java.util.Map;

public class Product {

    private Integer id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product() {}

    // Konstruktor som används i getAllProductTitles()
    public Product(String title) {
        this.title = title;
    }

    // Getters och Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}