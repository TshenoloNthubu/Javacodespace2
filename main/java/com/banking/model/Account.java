public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String branch;
    protected Customer customer;
    protected AccountType accountType;

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
        this.customer = customer;
        this.accountType = accountType;
    }

    public abstract boolean withdraw(double amount);
    public abstract void applyMonthlyInterest();

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }


    @Override
    public String toString() {
        return accountType + " Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", branch='" + branch + '\'' +
                '}';
    }
}