class BankAccount1 {
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    static String bankName = "ABC Bank";
    static int totalAccounts = 0;

    public BankAccount1(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount1) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: $" + balance);
        }
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public static void main(String[] args) {
        BankAccount1 acc1 = new BankAccount1("ACC101", "Alice", 5000.0);
        BankAccount1 acc2 = new BankAccount1("ACC102", "Bob", 7000.0);

        acc1.displayAccountDetails();
        System.out.println();
        acc2.displayAccountDetails();
        System.out.println();

        BankAccount1.getTotalAccounts();
    }
}
