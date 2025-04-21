package org.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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


        String[] name = {"Adri", "Damar", "Step"};


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

        int res = calculator((var a, var b) -> {
            return a + b;}, 5, 2);
        var res2 = calculator((var value1, var value2) -> value1 / value2, 5.20, 3.10);
        var res3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Joko", "Elted"
        );

        System.out.println(res3);
        System.out.println(res);
        System.out.println(res2);
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of Operation" + result);
        return result;
    }
}
