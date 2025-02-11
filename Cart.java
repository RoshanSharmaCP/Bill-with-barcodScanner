package com.possytem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();;
    private static final double TAX_RATE = 0.2;

    public void addItem(Product product, int  quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().getBarcode().equals(product.getBarcode()));
    }

    public double calculateSubtotal() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    public  double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        for (CartItem item : items) {
            System.out.println(item.getProduct().getName() + " x" + item.getQuantity() + " = Rs." + item.getSubtotal());
        }
        System.out.println("Subtotal: Rs." + calculateSubtotal());
        System.out.println("Tax: Rs." + calculateTax());
        System.out.println("Total: Rs." + calculateTotal());
    }
}
