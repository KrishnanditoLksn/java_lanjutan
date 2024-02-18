package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //autoboxing
        Integer boxedInt = 15;
        int unboxedInt = boxedInt.intValue();
        //wrapper class supports a method to return primitive value
        //manually unboxing

        //automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
        System.out.println(autoUnboxed);

        Double resultBoxed = getLiteralDoublePrimitive();
        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));

        System.out.println(wrapperArray[0].getClass().getName());
        //array of char
        Character[] charactersArray = {'a', 'b', 'c'};
        System.out.println(Arrays.toString(charactersArray));

        var outList = getList(1,2,3);
        //call via list

        var inList = List.of(1,2,3);
        System.out.println(outList);
    }


    private static ArrayList<Integer> getList(Integer... varargs) {
        ArrayList<Integer> aList = new ArrayList<>();
        //iterate over the values of the argument
        for (int i : varargs) {
            aList.add(i);
        }
        return aList;
    }

    //make a method that returns an int primitive type
    private static int returnAnInt(Integer i) {
        return i;
    }

    private static Integer returnAnInteger(int i) {
        return i;
    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    private static double getLiteralDoublePrimitive() {
        return 100.00;
    }
}