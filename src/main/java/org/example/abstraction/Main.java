package org.example.abstraction;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Wolf", "big", 100);
        doAnimalStuff(dog);
        //implement arrayList of an abstract type
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 160));
        animals.add(new Fish("Barracude", "big", 75));
        animals.add(new Horse("Jaran Kepang", "small", 1500));

        //iterate using foreach
        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal) {
                currentMammal.shedHair();
            }
        }
    }

    public static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("slow");
    }
}
