package app;
import model.*;
import model.Customer;
import model.Account;
import model.SavingsAccount;
import model.ChequeAccount;
import model.InvestmentAccount;

public class BankingSystemDemo {
    public static void main(String[] args) {
        System.out.println("=== BANKING SYSTEM CORE DEMO ===\n");

        // Create a customer
        Customer customer = new Customer("Mark", "Nthubu", "Gaborone");

        // Create accounts
        SavingsAccount savings = new SavingsAccount(customer, "Main Branch", 1000.00);
        ChequeAccount cheque = new ChequeAccount(customer, "Main Branch", 2000.00, "Botswana Corp", 5000.00);

        // Add accounts to customer
        customer.addAccount(savings);
        customer.addAccount(cheque);

        // Display customer info
        System.out.println("Customer: " + customer.getFirstname() + " " + customer.getSurname());
        System.out.println("Customer ID: " + customer.getCustomerId());

        // Savings account operations
        System.out.println("\n--- Savings Account ---");
        savings.deposit(500);
        savings.withdraw(200);
        System.out.println("Balance: BWP " + savings.getBalance());
        System.out.println("Interest: BWP " + savings.calculateInterest());

        // Cheque account operations
        System.out.println("\n--- Cheque Account ---");
        cheque.deposit(1000);
        cheque.withdraw(500);
        System.out.println("Balance: BWP " + cheque.getBalance());
        System.out.println("Employer: " + cheque.getEmployerName());
        System.out.println("Interest: BWP " + cheque.calculateInterest());

        // Investment account test
        System.out.println("\n--- Investment Account ---");
        try {
            InvestmentAccount investment = new InvestmentAccount(customer, "Main Branch", 600.00);
            System.out.println("Investment account created with balance: BWP " + investment.getBalance());
            System.out.println("Interest: BWP " + investment.calculateInterest());
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot create investment account: " + e.getMessage());
        }

        // Customer account summary
        System.out.println("\n--- Customer Account Summary ---");
        System.out.println(customer.getFirstname() + " has " + customer.getAccounts().size() + " accounts.");
        for (Account acc : customer.getAccounts()) {
            System.out.println(" - " + acc.getAccountNumber() + " | Balance: BWP " + acc.getBalance());
        }

        System.out.println("\n=== DEMO COMPLETE ===");
    }
}

