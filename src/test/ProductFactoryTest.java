package test;
import org.junit.jupiter.api.Test;
import src.OrderManager;
import src.Product;
import src.ProductFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductFactoryTest {

    ProductFactory productFactory=new ProductFactory();

    @Test
    public void testCreateElectronics() {
        Product electronics = productFactory.createProduct("electronics", "Laptop", 10, 1000);
        assertEquals("Laptop", electronics.getName());
        assertEquals(10, electronics.getStockQuantity());
        assertEquals(1000, electronics.getUnitPrice(), 0.01);
        assertEquals(1150, electronics.calculateTotalPrice(), 0.01);
    }


    @Test
    public void testCreateClothing() {
        Product clothing = productFactory.createProduct("clothing", "Shirt", 50, 20);
        assertEquals("Shirt", clothing.getName());
        assertEquals(50, clothing.getStockQuantity());
        assertEquals(20, clothing.getUnitPrice(), 0.01);
        assertEquals(22, clothing.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testCreateFurniture() {
        Product furniture = productFactory.createProduct("furniture", "Chair", 5, 100);
        assertEquals("Chair", furniture.getName());
        assertEquals(5, furniture.getStockQuantity());
        assertEquals(100, furniture.getUnitPrice(), 0.01);
        assertEquals(108, furniture.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testSortingByTotalPrice() {
        Product p1 = productFactory.createProduct("electronics", "Laptop", 10, 1000);
        Product p2 = productFactory.createProduct("clothing", "Shirt", 50, 20);
        Product p3 = productFactory.createProduct("furniture", "Chair", 5, 100);

        List<Product> products = Arrays.asList(p1, p2, p3);
        OrderManager orderManager = new OrderManager();
        orderManager.sortAndPrintProducts(products);

        assertEquals(p2, products.get(0));
        assertEquals(p3, products.get(1));
        assertEquals(p1, products.get(2));
    }


    @Test
    public void testSortingByNameWhenPriceIsEqual() {
        Product p1 = productFactory.createProduct("electronics", "A-Laptop", 10, 1000);
        Product p2 = productFactory.createProduct("electronics", "B-Laptop", 10, 1000);

        List<Product> products = Arrays.asList(p2, p1);
        OrderManager orderManager = new OrderManager();
        orderManager.sortAndPrintProducts(products);

        assertEquals(p1, products.get(0));
        assertEquals(p2, products.get(1));
    }


    @Test
    public void testSortingByStockQuantityWhenPriceAndNameAreEqual() {
        Product p1 = productFactory.createProduct("electronics", "Laptop", 5, 1000);
        Product p2 = productFactory.createProduct("electronics", "Laptop", 10, 1000);

        List<Product> products = Arrays.asList(p2, p1);
        OrderManager orderManager = new OrderManager();
        orderManager.sortAndPrintProducts(products);

        assertEquals(p1, products.get(0));
        assertEquals(p2, products.get(1));
    }

    @Test
    public void testSortingProductsSameCategoryDifferentPrices() {
        Product p1 = productFactory.createProduct("furniture", "Chair", 5, 100);
        Product p2 = productFactory.createProduct("furniture", "Sofa", 10, 500);

        List<Product> products = Arrays.asList(p2, p1);
        OrderManager orderManager = new OrderManager();
        orderManager.sortAndPrintProducts(products);

        assertEquals(p1, products.get(0));
        assertEquals(p2, products.get(1));
    }


    @Test
    public void testInvalidProductCategory() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productFactory.createProduct("toys", "Toy Car", 100, 10);
        });
        assertEquals("Unknown product category: toys", exception.getMessage());
    }


    @Test
    public void testSortingSamePriceDifferentStock() {
        Product p1 = productFactory.createProduct("electronics", "Phone", 5, 500);
        Product p2 = productFactory.createProduct("electronics", "Phone", 10, 500);

        List<Product> products = Arrays.asList(p2, p1);
        OrderManager orderManager = new OrderManager();
        orderManager.sortAndPrintProducts(products);

        assertEquals(p1, products.get(0)) ;
        assertEquals(p2, products.get(1));
    }


    @Test
    public void testSortingByAlphabeticalOrderSamePrice() {
        Product p1 = productFactory.createProduct("clothing", "T-Shirt", 50, 20);
        Product p2 = productFactory.createProduct("clothing", "Sweater", 50, 20);

        List<Product> products = Arrays.asList(p1, p2);
        OrderManager orderManager = new OrderManager();
        orderManager.sortAndPrintProducts(products);

        assertEquals(p2, products.get(0));
        assertEquals(p1, products.get(1));
    }


}
