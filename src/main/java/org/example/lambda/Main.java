package org.example.lambda;

import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Dito", "Laksana"),
                new Person("Joko", "Aldi")
        ));

        //By using comparator , we can custom sort by criteria
        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.fName().compareTo(o2.fName());
            }
        };


//        people.sort(comparatorLastName);
//        System.out.println(people);

        //using lambda
        people.sort(((o1, o2) -> o1.fName().compareTo(o2.fName())));

//        System.out.println(people);

        //Tell that is part of lambda expression
//        @FunctionalInterface
        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int res = o1.fName().compareTo(o2.fName());
                return (res == 0 ? secondLevel(o1, o2) : res);
            }


            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.fName().compareTo(o2.fName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);

        // s are iterated element
        people.forEach((s) -> System.out.println(s));


        String[] name = {"Adri", "Damar", "Step", "Danar", "Viko"};


        List<String> peoples = new ArrayList<>(Arrays.asList(name));

        System.out.println("-------");
        String prefix = "nota";
        //variable should be final that used  in lambda body

        peoples.forEach((var person) -> {
            char first = person.charAt(0);
            System.out.println(prefix + person + first);
        });

        /*
         *   this lambda override a method
         */

        int res = calculator(Integer::sum, 5, 2);
        var res2 = calculator((var value1, var value2) -> value1 / value2, 5.20, 3.10);
        var res3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Joko", "Elted"
        );

        System.out.println(res3);
        System.out.println(res);
        System.out.println(res2);

        var coords = Arrays.asList(
                new double[]{23.123123, 31.3123},
                new double[]{20.3221312, 71.75675},
                new double[]{63.75675645, 91.6775}
        );
        /*
         *Consumer does not return anything and take 1 parameter
         */
        coords.forEach((s) -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> pi = (lat, lng) -> System.out.printf("[lat:%3f  lon:%3f]%n", lat, lng);
        var firstPoint = coords.getFirst();
        System.out.println("--");
        processPoint(firstPoint[0], firstPoint[1],
                (lat, lng) -> System.out.printf("[lat:%3f  lon:%3f]%n", lat, lng));


        System.out.println("--");
        coords.forEach((s) -> processPoint(s[0], s[1], pi));

        //Predicate functional interface and return a  boolean result
        peoples.removeIf(
                s -> s.equalsIgnoreCase("adri")
        );

        peoples.removeIf(s -> s.startsWith("V"));

        peoples.forEach(System.out::println);


        peoples.replaceAll(s -> s.charAt(0) + " - "  + s.toUpperCase(Locale.ROOT));
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of Operation" + result);
        return result;
    }

    /**
     * BiConsumer does not return anything and takes 2  parameter
     */
    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }


}
