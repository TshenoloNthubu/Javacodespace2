package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {
    private String customerId;
    private String firstname;
    private String surname;
    private String address;
    private List<Account> accounts;

    public Customer(String firstname, String surname, String address) {
        this.customerId = "CUST" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getCustomerId() { return customerId; }
    public String getFirstname() { return firstname; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    public List<Account> getAccounts() { return accounts; }
}

