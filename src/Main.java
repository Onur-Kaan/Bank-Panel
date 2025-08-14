

//test
// Base class
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String holderName;
    protected double balance;

    // Constructor
    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "AccountNumber: " + accountNumber + ", HolderName: " + holderName + ", Balance: " + balance;
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends Account {
    private double withdrawalLimit;

    public SavingsAccount(String accountNumber, String holderName, double balance, double withdrawalLimit) {
        super(accountNumber, holderName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal amount exceeds the limit of " + withdrawalLimit);
        } else {
            super.withdraw(amount);
        }
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (balance + overdraftLimit)) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or exceeds overdraft limit.");
        }
    }
}

// Main class to demonstrate polymorphism
class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create instances of accounts
        Account savings = new SavingsAccount("SA123", "Ahmet Veli", 10000, 10000);
        Account checking = new CheckingAccount("CA456", "Aleyna Bilge", 10000, 10000);

        // Process accounts using polymorphism
        Account[] accounts = { savings, checking };

        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("Choose an operation: 1-Deposit, 2-Withdraw, 3-Exit");
            int choice;

            do {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Exiting operation for this account.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                System.out.println(account);
            } while (choice != 3);

            System.out.println("----------------------------");
        }

        scanner.close();
    }
}