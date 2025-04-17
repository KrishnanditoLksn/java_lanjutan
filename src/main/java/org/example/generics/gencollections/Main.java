package org.example.generics.gencollections;

import org.example.innerclass.Employee;
import org.example.innerclass.StoreEmployee;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.*;

interface Player {
    String name();
}

record FootballPlayer(String name, String position) implements Player {
}

public class Main {
    public static void main(String[] args) {

//        var abc = new Affiliation("city", "YK", "ID");
//        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
//        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
//        scoreResult(phillies1, 3, astros1, 5);
//
//        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
//        SportsTeam astros2 = new SportsTeam("Houston Astros");
//        scoreResult(phillies2, 3, astros2, 5);
//
//        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", abc);
//        Team<FootballPlayer, Affiliation> astros = new Team<>("Houston Astros", abc);
//        scoreResult(phillies, 3, astros, 5);
//
//        var harper = new BaseballPlayer("B Harper", "Right Fielder");
//        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
//        phillies.addTeamMember(harper);
//        phillies.addTeamMember(marsh);
//        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
//        phillies.addTeamMember(guthrie);
//        phillies.listTeamMembers();
//
//        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
//        Team<FootballPlayer, String> afc = new Team<>("Adelaide Crows", "dsa");
//        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
//        afc.addTeamMember(tex);
//        var rory = new FootballPlayer("Rory Laird", "Midfield");
//        afc.addTeamMember(rory);
//        afc.listTeamMembers();


        var nationalUsPark = new Park[]{
                new Park("YStone", "44.111, -110.212"),
                new Park("Glowstone", "41.111, -100.212")
        };

//        Team<FootballPlayer , Affiliation> adelaide = new Team<>("Adelaide Storm");
//        adelaide.addTeamMember("N Roberts");
//        adelaide.listTeamMembers();

        Layer<Park> parkLayer = new Layer<>(nationalUsPark);
        parkLayer.renderLayer();

        var majorUsParkRiver = new River[]{
                new River("Ongordio", "22.111, -31.123"),
                new River("Glowsku", "21.2321,-11.132")
        };

        Layer<River> riverLayer = new Layer<>(majorUsParkRiver);
        riverLayer.addElements(
                new River("Ongordis", "19.111, -31.123"),
                new River("Glowskus", "10.2321,-11.132")
        );
        riverLayer.renderLayer();


        Integer five = 5;
        Integer[] other = {0, 2, 1, 1};

        for (Integer i : other) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (
                    val == 0 ? "==" : (val < 0) ? "<" : ">"
            ), i, val);
        }

        Student student = new Student(
                "Tim"
        );

        Student[] students = {new Student("Joko"), new Student("Budi"), new Student("Adri")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));


        System.out.println("Result" + student.compareTo(new Student("Tim")));

//        System.out.println("Result = " + student.compareTo(students));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));

        //Anonymous class
        var c4 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };


        var c5 = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getYearsWorked() - o2.getYearsWorked();
            }
        };
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(1001, "Dito", 2012, "Target"),
                new StoreEmployee(1002, "Adit", 2013, "Walmart")
        ));


        //Local class

        class NameSort<T> implements Comparator<StoreEmployee> {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }


        class EmployeeSort<T> implements Comparator<Employee> {

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getYearsWorked() - o2.getYearsWorked();
            }
        }


        var c0 = new Employee.EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee().new StoreComparator<>();
        var c3 = new NameSort<StoreEmployee>();
        List<NewEmployees> employees = new ArrayList<>(List.of(
                new NewEmployees("Joko", "Vito", "23-12-2015"),
                new NewEmployees("Adri", "Divul", "1-1-1990"),
                new NewEmployees("Tio", "Pras", "3-12-2023"),
                new NewEmployees("Dion", "Yulis", "1-1-1999")
        ));

//        sortIt(storeEmployees, c0);
//        sortIt(storeEmployees, c1);
//        sortIt(storeEmployees, c2);
//        sortIt(storeEmployees, c3);
//        sortIt(storeEmployees, c4);
        sortOrderedList(employees, "name");

    }


    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {
        System.out.println("Sorting using Comparator" + comparator.toString());
        list.sort(comparator);
        for (var employee : list) {
            System.out.println(employee);
        }
    }

    public static <T> void sortOrderedList(List<NewEmployees> list, String sortField) {
        int currentYear = LocalDate.now().getYear();

        class TheEmployee {
            NewEmployees employee;
            int yearsWorked;
            String fullName;

            public TheEmployee(NewEmployees containEmployee) {
                this.employee = containEmployee;
                yearsWorked = currentYear - Integer.parseInt(
                        containEmployee.hireDate().split("-")[2]);
                fullName = String.join(" ",
                        containEmployee.fName(),
                        containEmployee.lName()
                );
            }

            @Override
            public String toString() {
                return "%s has been employee for %d years".formatted(
                        fullName, yearsWorked
                );
            }

        }

        List<TheEmployee> listEmp = new ArrayList<>();
        for (NewEmployees employees : list) {
            listEmp.add(new TheEmployee(employees));
        }

        var comparator = new Comparator<TheEmployee>() {

            @Override
            public int compare(TheEmployee o1, TheEmployee o2) {
                if (sortField.equals("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        listEmp.sort(comparator);

        for (TheEmployee theEmployee : listEmp) {
            System.out.println(theEmployee);
        }
    }


//    public static void scoreResult(BaseballTeam team1, int t1_score,
//                                   BaseballTeam team2, int t2_score) {
//
//        String message = team1.setScore(t1_score, t2_score);
//        team2.setScore(t2_score, t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
//
//    public static void scoreResult(SportsTeam team1, int t1_score,
//                                   SportsTeam team2, int t2_score) {
//
//        String message = team1.setScore(t1_score, t2_score);
//        team2.setScore(t2_score, t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
//
//    public static void scoreResult(Team team1, int t1_score,
//                                   Team team2, int t2_score) {
//
//        String message = team1.setScore(t1_score, t2_score);
//        team2.setScore(t2_score, t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
}

class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}


class Student implements Comparable<Student> {
    private static int LAST_ID = 1000;
    private static Random random = new Random();
    protected String name;
    protected double gpa;
    private int id;


    public Student(
            String name
    ) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(@NotNull Student o) {

        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}
