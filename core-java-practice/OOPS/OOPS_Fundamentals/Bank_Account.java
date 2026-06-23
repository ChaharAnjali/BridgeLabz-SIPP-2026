class BankAccount {
    int accountNumber;
    String holder;
    double balance;
   
    static int totalAccounts = 0;

    // constructor
    BankAccount(int accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }
    void withdraw(double amount) {
        if (amount <= balance) {
          balance = balance - amount;
          System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Transaction Failed! Insufficient Balance");
        }
    }
    void getStatement() {
        System.out.println(" ");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holder);
        System.out.println("Balance: " + balance);
        System.out.println(" ");
    }

}
public class Bank_Account {
       public static void main(String[] args) {
        BankAccount a1 = new BankAccount(101, "AC", 10000);
        BankAccount a2 = new BankAccount(102, "Chahar", 15000);
        BankAccount a3 = new BankAccount(103, "Anjali", 20000);

         // Account 1 (5 Transactions)
        a1.deposit(5000);
        a1.withdraw(2000);
        a1.deposit(1000);
        a1.withdraw(3000);
        a1.withdraw(15000);
        a1.getStatement();

        // Account 2 (5 Transactions)
        a2.deposit(2000);
        a2.withdraw(500);
        a2.deposit(1500);
        a2.withdraw(10000);
        a2.deposit(700);
        a2.getStatement();

        // Account 3 (5 Transactions)
        a3.withdraw(5000);
        a3.deposit(3000);
        a3.withdraw(4000);
        a3.deposit(1000);
        a3.withdraw(25000);
        a3.getStatement();

        System.out.println("Total Accounts Created = " + BankAccount.totalAccounts);
    }
}
       