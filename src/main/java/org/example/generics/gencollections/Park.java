package org.example.generics.gencollections;

public class Park extends Points {
    private String name;

    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "National Park";
    }
}
