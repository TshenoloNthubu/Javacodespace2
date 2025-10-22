package model;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.0005;

    public SavingsAccount(Customer customer, String branch, double initialDeposit) {
        super(customer, branch, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew BWP " + amount + " from savings account");
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

