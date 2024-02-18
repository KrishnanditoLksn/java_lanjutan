package org.example.abstraction;

abstract class Mammal extends Animal {
    //abstract class doesn't have to implement abstract methods
    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.println(getExplicitType() + " ");
        System.out.println(speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();

}


public abstract class Animal {
    private final double weight;
    protected String type;
    protected String size;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    //abstract can't have a body method
    public abstract void move(String speed);

    public abstract void makeNoise();

    public final String getExplicitType() {
        return getClass().getSimpleName() + "(" + type + ")";
    }

}
