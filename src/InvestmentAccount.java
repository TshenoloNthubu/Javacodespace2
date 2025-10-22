package model;

public class InvestmentAccount extends Account {
    private static final double INTEREST_RATE = 0.05;
    private static final double MIN_OPENING_BALANCE = 500.00;

    public InvestmentAccount(Customer customer, String branch, double initialDeposit) {
        super(customer, branch, initialDeposit);
        if (initialDeposit < MIN_OPENING_BALANCE) {
            throw new IllegalArgumentException("Minimum balance: BWP 500.00 required");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew BWP " + amount + " from investment account");
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

