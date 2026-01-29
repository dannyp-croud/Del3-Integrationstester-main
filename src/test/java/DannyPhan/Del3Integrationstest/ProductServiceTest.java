package DannyPhan.Del3Integrationstest;

import org.junit.jupiter.api.Test;
import DannyPhan.Del3Integrationstest.model.Product;
import DannyPhan.Del3Integrationstest.service.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    // VG-krav
    private final ProductService productService = new ProductService();

    @Test
    void getAllProductTitles_returnsCorrectNumberOfProducts() {
        // Hämtar listan med produkter
        List<Product> products = productService.getAllProductTitles();

        assertNotNull(products);
        // Fake Store API innehåller som standard 20 produkter
        assertEquals(20, products.size());
    }

    @Test
    void getProductById_firstProduct_containsCorrectMappedData() {
        // Hämtar produkt med ID 1 (Fjallraven - Foldsack No. 1, Backpack, Fits 15 Laptops)
        Product product = productService.getProductById(1);

        assertNotNull(product);

        // Verifierar olika produktattribut och egenskaper
        assertEquals(1, product.getId());
        assertEquals("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", product.getTitle());
        assertEquals(109.95, product.getPrice());
        assertEquals("men's clothing", product.getCategory());

        // Verifierar att beskrivningen börjar korrekt
        assertTrue(product.getDescription().startsWith("Your perfect pack"));

        // Verifierar bild-URL:en
        assertEquals("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png", product.getImage());
    }
}