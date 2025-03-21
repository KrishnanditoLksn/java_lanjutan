package org.example.generics.gencollections;

import java.util.Arrays;

interface Mappable {
    void render();

    static double[] stringToLation(String location) {
        var splits = location.split(",");
        double lat = Double.parseDouble(splits[0]);
        double lon = Double.parseDouble(splits[1]);
        return new double[]{lat, lon};
    }
}


abstract class Points implements Mappable {
    private double[] location = new double[2];


    public Points(String location) {
        this.location = Mappable.stringToLation(location);
    }

    @Override
    public void render() {
        System.out.println("Render" + this + "as POINT" + location());
    }

    private String location() {
        return Arrays.toString(location);
    }
}


abstract class Line implements Mappable {
    private double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations) {
            this.locations[index++] = Mappable.stringToLation(l);
        }
    }

    private String locations() {
        return Arrays.deepToString(locations);
    }

    @Override
    public void render() {
        System.out.println("Render" + this + "at LINE " + locations());
    }
}