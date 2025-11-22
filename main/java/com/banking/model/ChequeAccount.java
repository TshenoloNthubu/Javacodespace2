public class ChequeAccount extends Account {
    private String employerName;
    private String companyAddress;

    public ChequeAccount(String accountNumber, double balance, String branch, Customer customer,
                         String employerName, String companyAddress) {
        super(accountNumber, balance, branch, customer, AccountType.CHEQUE);
        this.employerName = employerName;
        this.companyAddress = companyAddress;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyInterest() {
    }


    @Override
    public String toString() {
    }
}