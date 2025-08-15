

//test
// Base class
import java.util.Scanner;

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

