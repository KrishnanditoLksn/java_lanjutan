package org.example.generics.gencollections;

public class River extends Line {
    private String name;

    public River(String name, String locations) {
        super(locations);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "National Park";
    }
}
