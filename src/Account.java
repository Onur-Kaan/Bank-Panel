
class Account {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) { balance += amount; System.out.println("Deposited: " + amount); }
        else { System.out.println("Invalid deposit amount."); }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { balance -= amount; System.out.println("Withdrawn: " + amount); }
        else { System.out.println("Invalid withdrawal amount or insufficient funds."); }
    }

    @Override
    public String toString() {
        return "AccountNumber: " + accountNumber + ", HolderName: " + holderName + ", Balance: " + balance;
    }
}
