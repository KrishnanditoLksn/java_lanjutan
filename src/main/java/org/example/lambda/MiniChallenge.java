package org.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class MiniChallenge {
    public static void main(String[] args) {
        String[] name = {"Adri", "Damar", "Step", "Danar", "Viko"};


        List<String> peoples = new ArrayList<>(Arrays.asList(name));


        System.out.println("MINI CHALLENGE ");

        String split = "split it bro ";
        peoples.forEach(s -> System.out.println(Arrays.toString(s.split(" "))));

        System.out.println("-------------");
        Consumer<String> printTheParts = s -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Consumer<String> printWordsLambda = s -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };


        Consumer<String> printWordsEach = s -> {
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach(System.out::println);
        };
        printWordsLambda.accept(" Split array ");
        printWordsEach.accept(split);
        printTheParts.accept(split);

        System.out.println("---");
        /*
         * Concise version
         */

        Consumer<String> printWordsConcise = s -> {
            Arrays.asList(s.split(" ")).forEach(System.out::println);
        };

        printWordsConcise.accept(split);


        Consumer<String> everySecondChar = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            System.out.println(returnVal);
        };

        everySecondChar.accept(split);

        System.out.println("NUM BRO TAPI STRING ");
        String num = "1234567890";
        UnaryOperator<String> everySecondCharUnary = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return String.valueOf(returnVal);
        };
        System.out.println(everySecondCharUnary.apply(num));

    }
}
