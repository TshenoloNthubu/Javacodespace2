package model;

import java.util.UUID;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String branch;
    protected Customer customer;

    public Account(Customer customer, String branch, double initialDeposit) {
        this.customer = customer;
        this.branch = branch;
        this.balance = initialDeposit;
        this.accountNumber = "ACC" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited BWP " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public abstract void withdraw(double amount);
    public abstract double calculateInterest();

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getBranch() { return branch; }
}
