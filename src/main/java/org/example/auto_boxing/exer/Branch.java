package org.example.auto_boxing.exer;

import java.util.ArrayList;

public class Branch {
    private final String name;
    protected ArrayList<Customer> customers = new ArrayList<>();


    public Branch(String branchName) {
        this.name = branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialCustomerTransaction) {
        Customer customer;
        if (findCustomer(name) == null) {
            customer = new Customer(name, initialCustomerTransaction);
            customers.add(customer);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    public Customer findCustomer(String customerName) {
        for (var customer : customers) {
            if (customer.getName().equals(customerName)) {
                System.out.println("Customer found");
                return customer;
            }
        }
        return null;
    }
}
