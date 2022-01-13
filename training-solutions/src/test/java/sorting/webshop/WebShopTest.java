package sorting.webshop;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebShopTest {

    List<Product> testProducts = new ArrayList<>(List.of(
            new Product("Winchester", 10, LocalDateTime.of(2013, 1, 1, 10, 12)),
            new Product("SSD", 8, LocalDateTime.of(2014, 1, 1, 10, 12)),
            new Product("Earphone", 12, LocalDateTime.of(2016, 1, 1, 10, 12)),
            new Product("Mouse", 1, LocalDateTime.of(2017, 1, 1, 10, 12)),
            new Product("Phone", 5, LocalDateTime.of(2015, 1, 1, 10, 12))
    ));
    WebShop webShop = new WebShop(testProducts);

    @Test
    void testGetProductsOrderByName() {
        List<Product> result = webShop.getProductsOrderByName();

        assertEquals("Earphone", result.get(0).getName());
        assertEquals("Mouse", result.get(1).getName());
        assertEquals("Winchester", result.get(4).getName());
        assertEquals(testProducts, webShop.getProducts());
    }

    @Test
    void testGetProductsOrderByPrice() {
        List<Product> result = webShop.getProductsOrderByPrice();

        assertEquals("Mouse", result.get(0).getName());
        assertEquals("Winchester", result.get(3).getName());
        assertEquals("Earphone", result.get(4).getName());
        assertEquals(testProducts, webShop.getProducts());
    }

    @Test
    void testGetProductsOrderByDate() {
        List<Product> result = webShop.getProductsOrderByDate();

        assertEquals("Winchester", result.get(0).getName());
        assertEquals("Earphone", result.get(3).getName());
        assertEquals("Mouse", result.get(4).getName());
        assertEquals(testProducts, webShop.getProducts());
    }

}