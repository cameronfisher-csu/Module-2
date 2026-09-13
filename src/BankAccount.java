public class BankAccount {
    protected String firstName;
    protected String lastName;
    protected int accountID;
    protected double balance;

    // Getters and Setters for required variables
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public int getAccountID(){ return accountID; }
    public double getBalance(){ return balance; }

    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setAccountID(int accountID){ this.accountID = accountID; }

    // Constructor sets balance to 0
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if  (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    protected void accountSummary() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: " + balance);
    }
}
