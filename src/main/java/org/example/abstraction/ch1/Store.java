package org.example.abstraction.ch1;

import java.util.ArrayList;
import java.util.Vector;

record OrderItem(int quantity, ProductForSale productForSale) {
}

public class Store {
    private static final Vector<ProductForSale> storeProducts = new Vector<>();

    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Oil Painting ", 1350, "Bocil kematian  , 2020"));
        storeProducts.add(new ArtObject("Narto ", 1250, "Bocil kehidupan   , 2019"));

        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        listProducts();
    }

    //get all lists of products
    public static void listProducts() {
        for (var item : storeProducts) {
            item.showDetails();
        }
    }

    //add item to order
    public static void addItemToOrder(ArrayList<OrderItem> orderItems, int orderIndex, int quantity) {
        orderItems.add(new OrderItem(quantity, storeProducts.get(orderIndex)));
    }
}
