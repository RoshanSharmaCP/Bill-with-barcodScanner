package com.possytem;

/**
 * Hello world!
 *
 */
import java.util.HashMap;
import java.util.Map;

public class App 
{
    private final Cart cart;
    private final Map<String, Product> productCatalog;
    public App() {
        this.cart = new Cart();
        this.productCatalog = new HashMap<>();

        // Sample Products
        productCatalog.put("12345", new Product("12345", "Milk", 2.5));
        productCatalog.put("67890", new Product("67890", "Bread", 1.5));
        productCatalog.put("11111", new Product("11111", "Eggs", 3.0));
    }

    public void scanBarcode(String barcode, int quantity) {
        Product product = productCatalog.get(barcode);
        if (product != null) {
            cart.addItem(product, quantity);
            System.out.println(product.getName() + " added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void checkout() {
        cart.printReceipt();
    }

    public static void main(String[] args) {
        App pos = new App();
        pos.scanBarcode("12345", 2); // Milk x2
        pos.scanBarcode("67890", 1); // Bread x1
        pos.checkout();
    }

}
