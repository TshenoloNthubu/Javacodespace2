package main.java.com.banking.model;

public class InvestmentAccount extends Account {
    private static final double MONTHLY_INTEREST_RATE = 0.05; // 5%
    private static final double MINIMUM_BALANCE = 500.00;

    public InvestmentAccount(String accountNumber, double balance, String branch, Customer customer) {
        super(accountNumber, balance, branch, customer, AccountType.INVESTMENT);
        if (balance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Investment account requires minimum balance of " + MINIMUM_BALANCE);
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
            return true;
        }
        System.out.println("Insufficient funds for withdrawal");
        return false;
    }

    @Override
    public void applyMonthlyInterest() {
        double interest = balance * MONTHLY_INTEREST_RATE;
        balance += interest;
        System.out.println("Applied monthly interest: " + interest + " to Investment Account: " + accountNumber);
    }
}