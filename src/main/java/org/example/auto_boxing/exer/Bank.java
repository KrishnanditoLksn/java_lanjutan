package org.example.auto_boxing.exer;

import java.util.ArrayList;

public class Bank {
    private  String name;
    protected ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.name = bankName;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String name) {
        // if branch doesn't null add
        if (findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerBranchName, double initialTransaction) {
        //It returns true if the customer was added successfully or false otherwise
        if (findBranch(branchName) != null) {
            findBranch(branchName).newCustomer(customerBranchName, initialTransaction);
            System.out.println("Success added customer , dude !! ");
            return true;
        }
        System.out.println("Failed added customer , dude !! ");
        return false;
    }

    //add customer transaction in a list
    public boolean addCustomerTransaction(String branchName, String customerBranchName, double transaction) {
        //It returns true if the customer's transaction was added successfully or false otherwise
        if(findBranch(branchName) != null){
            findBranch(branchName).addCustomerTransaction(customerBranchName, transaction);
            return  true;
        }
        return false;
    }

    //validate using findBranch
    private  Branch findBranch(String branchName) {
        //Return the Branch if it exists or null otherwise
        for (var branch : branches) {
            if (branch.getName().equalsIgnoreCase(branchName))
                return branch;
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
