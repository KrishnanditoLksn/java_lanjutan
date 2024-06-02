package org.example.interfaces;

class Satelite implements OrbitEarth{

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

/*
extending an interface
 */


interface OrbitEarth extends FlightEnable{
    void achieveOrbit();
}


interface FlightEnable {
    void move();

    void takeOff();
    abstract void land();
    void fly();
}

interface Trackable {
     void track();
}

public abstract class Animal {
    public abstract void move();
}
