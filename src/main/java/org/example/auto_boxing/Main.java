package org.example.auto_boxing;

import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {
    //takes
    public Customer(String name, double initialDeposit) {
        this(name.toUpperCase(),
                new ArrayList<>(500));
        transactions.add(initialDeposit);
    }
}

public class Main {
    public static void main(String[] args) {
        Customer bob = new Customer("Bob", 1000.0);
        System.out.println(bob);
        Bank bank = new Bank("Chase");
        bank.addNewCustomer("Dito", 2000.00);
        System.out.println(bank);
        bank.addTransaction("Dito", -75.01);
        bank.printStatement("Dito");
    }
}

class Bank {
    private final String name;
    private final ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    //search the customer
    private Customer getCustomer(String customerName) {
        for (var customer : customers) {
            if (customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        System.out.printf("Customer (%s) wasn't found %n", customerName);
        return null;
    }

    //add transaction method
    public void addTransaction(String name, double transactionAmount) {
        Customer customer = getCustomer(name);
        //check if customer exists

        if (customer != null) {
            customer.transactions().add(transactionAmount);
        }
    }

    //add new customer
    public void addNewCustomer(String customerName, double initialDeposit) {
        //if customer null

        if (getCustomer(customerName) == null) {
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New Customer added : " + customer);
        }
    }

    public void printStatement(String customerName) {
        Customer customer = getCustomer(customerName);
        //check if customer not null

        if (customer == null) {
            return;
        }
        System.out.println("-".repeat(30));
        System.out.println("Customer Name : " + customer.name());
        System.out.println("Transactions:");
        for (double d : customer.transactions()) {//UNBOXING
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "Credit");
        }
    }


    @Override
    public String toString() {
        return "Bank {" +
                "name = " + name + '\'' + customers + '}';
    }
}
