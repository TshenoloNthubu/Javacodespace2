import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;
    private List<Account> accounts;

        this.customerId = customerId;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public String getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    public List<Account> getAccounts() { return accounts; }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public boolean removeAccount(Account account) {
        return accounts.remove(account);
    }

    @Override
    public String toString() {
        return "Customer{" +
                '}';
    }
}