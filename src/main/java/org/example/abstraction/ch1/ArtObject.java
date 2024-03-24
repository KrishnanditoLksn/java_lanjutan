package org.example.abstraction.ch1;

//implement abstract method
public class ArtObject extends ProductForSale {
    public ArtObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This" + type + "is a good reproduction ");
        System.out.println(description);
    }
}
