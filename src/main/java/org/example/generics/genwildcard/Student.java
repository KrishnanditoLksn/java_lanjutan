package org.example.generics.genwildcard;

import org.jetbrains.annotations.NotNull;

import java.util.*;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}


public class Student implements QueryItem, Comparable<Student> {
    private static int incrementId = 1;
    private int id;
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
        id = incrementId++;
        yearStarted = random.nextInt(2022, 2025);
    }


    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        String fName = fieldName.toUpperCase(Locale.ROOT);
        return switch (fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return Integer.compare(id, o.id);
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


        var queryList = new QueryList<>(mobileStudents);
        var matches = queryList.getMatches("Course", "Py");
        printMoreList(matches);


        var student2 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreList(student2);
//
//        System.out.println("MOBILE");
//        var mobileStudent3 = QueryList.getMatches(mobileStudents, "Percent", "1.2");
//        printMoreList(mobileStudent3);

        QueryList<MobileStudent> mobileStudentQueryList = new QueryList<>();

        for (int i = 0; i < 5; i++) {
            mobileStudentQueryList.add(new MobileStudent());
        }
        mobileStudentQueryList.sort(Comparator.naturalOrder());

        var mobileStudent4 = QueryList.getMatches(mobileStudentQueryList, "Percent", "2.1");
        printMoreList(mobileStudent4);
        //CANT DO IT
//        QueryList<Employee> employeeQueryList = new QueryList<Employee>();
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
