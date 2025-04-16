package org.example.innerclass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1001, "Dito", 2012),
                new Employee(1002, "Adit", 2013),
                new Employee(1003, "Denis", 2014)
        ));

        employees.sort(new Employee.EmployeeComparator<>("yearStarted"));

        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("Store Members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(1001, "Dito", 2012, "Target"),
                new StoreEmployee(1002, "Adit", 2013, "Walmart")
        ));
        var genericEmployee = new StoreEmployee();
        var comparator = genericEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator);
        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }

        System.out.println("With Pig Latin name ");
        addPigLatinName(storeEmployees);
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        String lastName = "Piggy";


        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {
            private String pigLatinName;
            private Employee originalInstance;


            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + pigLatinName;
            }

            @Override
            public int compareTo(@NotNull DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        /*
         If  null was passed  , it will use comparable compare to method
         */
        newList.sort(null);
        for (var employee2 : newList) {
            System.out.println(employee2.originalInstance.getName() + " " + employee2.pigLatinName);
        }
    }
}