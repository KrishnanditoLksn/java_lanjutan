package org.example.interfaces;

public class Main {
    public void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = new Bird();
        /*
        using manual instantiation
         */

//        Trackable trackable = bird;
//        animal.move();
//        FlightEnable flightEnable = bird;
//        trackable.track();
//        flightEnable.fly();

        /*
        inline instantiation
         */


//        ((Animal)bird).move();
//        ((Trackable) bird).track();
//        ((FlightEnable) bird).fly();

        inFlight(bird);
        inFlight(new Jet());

        System.out.println(checkInstance(bird));
    }

    private  static void inFlight(FlightEnable flier){
        flier.takeOff();
        flier.fly();

        if (flier instanceof Trackable trackable){
            trackable.track();
        }
        flier.land();
    }

    public static  boolean checkInstance(Bird bird){
        return bird != null;
    }
}
