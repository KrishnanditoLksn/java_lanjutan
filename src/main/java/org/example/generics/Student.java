package org.example.generics;

import java.util.ArrayList;
import java.util.List;
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
        printList(students);

        List<MobileStudent> mobileStudents = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            mobileStudents.add(new MobileStudent());
        }

        printList(mobileStudents);
    }

    public static <T> void printList(List<T> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
