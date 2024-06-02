package org.example.interfaces;

/*
Bird class implement Trackable and extend Animal
 */
public class Bird extends Animal implements Trackable, FlightEnable {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + "Hey wingss");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "Bird have a track");
    }


    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + "The bird is take off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + "The bird is Landing");
    }

    @Override
    public void fly() {
        System.out.println("The bird is fly");
    }

}
