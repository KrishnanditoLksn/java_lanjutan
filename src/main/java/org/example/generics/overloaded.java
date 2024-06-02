package org.example.generics;

public class overloaded {

    public static void main(String[] args) throws InvalidSubscriptException {
        /*
        Type parameters can represent only reference types—not primitive types (like
        int, double and char)
         */
        Character[] arrs = {'A', 'B', 'C'};
        printArray(arrs, 110, 10);
//        System.out.println();
//        printArrayObjectType(arrs);
//        System.out.println();
//        System.out.println(max(1, 4, 1));
    }

    public static <T> void printArray(T[] inputArrs, int lowSubscript, int highSubscript) throws InvalidSubscriptException {
        if (lowSubscript < 0 || highSubscript >= inputArrs.length) {
            throw new InvalidSubscriptException("Error has occured");
        }

        for (T element : inputArrs) {
            System.out.printf("%s ", element);
        }
    }

    public static <Object> void printArrayObjectType(Object[] arr) {
        for (Object i : arr) {
            System.out.printf("%s ", i);
        }
    }

    public static <T extends Comparable<T>> T max(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    /*
    create an  custom exception
     */
    public static class InvalidSubscriptException extends Exception {
        public InvalidSubscriptException(String msg) {
            super(msg);
        }
    }
}
