package org.example.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Student {
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();

    private static String[] firstNames = {"Joko", "Mul", "Udi", "Hadi", "Jerome"};
    private static String[] courses = {"Py", "Java", "C++"};

    public Student() {
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2022, 2025);
    }


    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }
}

class Main {
    public static void main(String[] args) {
        int c = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            students.add(new Student());
        }
        students.add(new MobileStudent());
        printMoreList(students);

        List<MobileStudent> mobileStudents = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            mobileStudents.add(new MobileStudent());
        }

        printMoreList(mobileStudents);

        testList(new ArrayList<Integer>(List.of(1, 2, 3)));
        testList(new ArrayList<String>(List.of("Joko", "Aghad")));
    }

//    public static <T extends Student> void printList(List<T> students) {
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + " : " + student);
//        }
//        System.out.println();
//    }

    public static void printMoreList(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    //    public static void testList(List<String> students) {
//        for (var student : students) {
//            System.out.println(student.toUpperCase(Locale.ROOT));
//        }
//        System.out.println();
//    }
    public static void testList(List<?> students) {
        for (var student : students) {
            if (student instanceof String s) {
                System.out.println("String:" + s.toUpperCase(Locale.ROOT));
            } else if (student instanceof Integer i) {
                System.out.println("Integer:" + i.floatValue());
            }
        }
        System.out.println();
    }
}
