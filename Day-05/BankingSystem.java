interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility(double salary);
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.03;  // Current account has a fixed interest rate
    }
}

class LoanAccount extends BankAccount implements Loanable {
    private double loanAmount;

    LoanAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.05;  // Loan account interest rate
    }

    @Override
    public void applyForLoan(double amount) {
        loanAmount = amount;
        System.out.println("Loan of $" + loanAmount + " applied.");
    }

    @Override
    public boolean calculateLoanEligibility(double salary) {
        return salary >= loanAmount * 0.5;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new SavingsAccount("S123", "Alice", 5000, 0.04);
        accounts[1] = new CurrentAccount("C456", "Bob", 3000, 1000);
        accounts[2] = new LoanAccount("L789", "Charlie", 2000);

        double salary = 4000;  // Salary for loan eligibility check

        for (BankAccount account : accounts) {
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Account Type: " + account.getClass().getSimpleName());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Interest: $" + account.calculateInterest());

            if (account instanceof LoanAccount) {
                LoanAccount loanAccount = (LoanAccount) account;
                loanAccount.applyForLoan(5000);
                boolean isEligible = loanAccount.calculateLoanEligibility(salary);
                System.out.println("Loan Eligibility: " + (isEligible ? "Eligible" : "Not Eligible"));
            }

            System.out.println();
        }
    }
}

