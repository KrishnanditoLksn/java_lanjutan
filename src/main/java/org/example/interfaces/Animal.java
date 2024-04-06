package org.example.interfaces;

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
