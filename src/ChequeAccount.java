package model;

public class ChequeAccount extends Account {
    private String employerName;
    private double monthlyIncome;

    public ChequeAccount(model.Customer customer, String branch, double initialDeposit,
                         String employerName, double monthlyIncome) {
        super(customer, branch, initialDeposit);
        this.employerName = employerName;
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew BWP " + amount + " from cheque account");
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount");
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public String getEmployerName() { return employerName; }
}

