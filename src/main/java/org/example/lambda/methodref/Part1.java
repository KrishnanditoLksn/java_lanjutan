package org.example.lambda.methodref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.*;

class PlainOld {
    private static int last_id = 1;
    private final int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Incrementing plainold object" + id);
    }
}

public class Part1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Anno", "Joko", "Diro"
        ));

        list.forEach(
                System.out::println
        );
        /*
         * Method references in lambda don't required params like system out println
         */
        calculator(Integer::sum, 1, 2);
        calculator(Double::sum, 1.9, 1.1);


        Supplier<PlainOld> supplier = PlainOld::new;
        PlainOld pojo = supplier.get();
        System.out.println("Get array !!");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);


        calculator((s1, s2) -> s1 + s2, "Hello", "Joko");

        /*
         * Forward s1 and s2 params using binary operator apply function
         */

        calculator(String::concat, "Hello", "Joko");

        BinaryOperator<String> b1 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> b2 = (s1, s2) -> s1.concat(s2);
        UnaryOperator<String> b3 = (s1) -> s1.toUpperCase(Locale.ROOT);

        System.out.println(b1.apply("Hello", "Joko"));
        System.out.println(b3.apply("Hello"));

        /*
         * Transform String into another string
         */
        String res = "Hello".transform(b3);
        System.out.println("Result  = " + res);

        res = res.transform(String::toLowerCase);
        System.out.println("Result = " + res);


        Function<String, Boolean> f0 = String::isEmpty;
        boolean resBool = res.transform(f0);
        System.out.println("Result = " + resBool);
    }


    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println(" Result of operation " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> ref, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> ref.get());
        return array;
    }
}
