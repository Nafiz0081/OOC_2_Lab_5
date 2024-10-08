package src;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductFactory factory=new ProductFactory();
        List<Product>products=new ArrayList<>();

        Product p1=factory.createProduct("Electronics","Dell Laptop",10,100.00);
        Product p2=factory.createProduct("Furniture","Chair",10,100.00);
        Product p3=factory.createProduct("Clothing","T-Shirt",10,100.00);

        OrderManager manager=new OrderManager();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        manager.sortAndPrintProducts(products);


    }
}