package src;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderManager{

    public void sortAndPrintProducts(List<Product> products) {
        Collections.sort(products, Comparator.comparingDouble(Product::calculateTotalPrice)
                .thenComparing(Product::getName)
                .thenComparing(Product::getStockQuantity));

        for (Product product : products) {
            System.out.println(product.getName() + ", Total Price: " + product.calculateTotalPrice());
        }


    }

}

