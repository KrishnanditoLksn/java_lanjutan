package org.example.interfaces;

//implements constants list
enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStages() {
        FlightStages[] flightStages = values();
        return flightStages[(ordinal() + 1) % flightStages.length];
    }
}

interface OrbitEarth extends FlightEnable {
    void achieveOrbit();
}

/*
extending an interface
 */

interface FlightEnable {

    double MILES_TO_KM = 1.59595;
    double KM_TO_MILES = 1.44324;

    void move();

    void takeOff();

    void land();

    void fly();

    default void transitions(FlightStages stages) {
        System.out.println("Transition not implemented on " + this.getClass().getName());
    }

}

interface Trackable {
    void track();

}

record Dragon(String name, String type) implements FlightEnable {

    @Override
    public void move() {

    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satelite implements OrbitEarth {

    @Override
    public void achieveOrbit() {
        System.out.println("Orbit achieved");
    }

    @Override
    public void move() {

    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

public abstract class Animal {
    public abstract void move();
}
