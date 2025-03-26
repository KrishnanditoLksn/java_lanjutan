package org.example.innerclass;

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
    }
}