import java.util.Scanner;

public class BankAccount {

    String clientId;
    String clientName;
    int balance;
    int previousTransaction;

    BankAccount (String clientId, String clientName) {
        this.clientId = clientId;
        this.clientName = clientName;
    }

    void deposit(int amount) {
        if(amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;
            previousTransaction = -amount;
        }
        else {
            System.out.println("Request denied.");
        }
    }

    void showPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if(previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transactions made.");
        }
    }
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME " + clientName);
        System.out.println("Your ID is: " + clientId);
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. View Previous Transaction");
        System.out.println("5. Exit");

        do {
            System.out.println("================");
            System.out.println("Enter an option: ");
            System.out.println("================");
            option = scanner.next().charAt(0);

            switch(option) {

                case '1':
                 System.out.println("Your balance is: " + balance);
                 System.out.println();
                 break;

                case '2':
                    System.out.println("Enter an amount to deposit: ");
                    int amtD = scanner.nextInt();
                    deposit(amtD);
                    System.out.println("Current balance: " + balance);
                    System.out.println();
                  break;

                case '3':
                    System.out.println("Enter an amount to withdraw: ");
                    int amtW = scanner.nextInt();
                    withdraw(amtW);
                    System.out.println("Current balance: " + balance);
                    System.out.println();
                    break;

                case '4':
                    System.out.print("Previous transaction:  ");
                    showPreviousTransaction();
                    System.out.println();
                    break;

                case '5':
                    System.out.println(".................................");
                    break;

                default:
                    System.out.println("Enter a number 1 - 5. Please try again. ");
                    System.out.println();
                    break;
            }
        } while (option != '5');

        System.out.println("Thank you for using our service.");
        System.out.println(".................................");
    }
}
