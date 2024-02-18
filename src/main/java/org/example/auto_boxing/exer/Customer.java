package org.example.auto_boxing.exer;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public String setName() {
        return name;
    }

    public void addTransaction(double transaction) {
        if (transactions != null) {
            transactions.add(transaction);
        }
    }

    public ArrayList<Double> getTransactions() {
      return  transactions;
    }
}
