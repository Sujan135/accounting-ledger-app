package com.pluralsight;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static ArrayList<Transaction> transactions = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Welcome to the Accounting Ledger!");
            System.out.println("Please select an option:");
            System.out.println("D. Add Deposit");
            System.out.println("P. Make Payment");
            System.out.println("L. Ledger");
            System.out.println("x. Exit");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    addDeposit(scanner);
                    break;
                case "P":
                    makePayment(scanner);
                    break;
                case "L":
                    displayLedger();
                    break;
                case "X":
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again:");
                    break;
            }
        }
    }

    // Created method to add deposit
    private static void addDeposit(Scanner scanner) {
        System.out.println("Enter deposit description: ");
        String description = scanner.nextLine();

        System.out.println("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Transaction deposit = new Transaction("Deposit", description, amount);
        transactions.add(deposit);

        System.out.println("Deposit of $" + amount + " added with description: " + description);
    }

    // Created method for making a payment
    private static void makePayment(Scanner scanner) {
        System.out.println("Enter payment description: ");
        String description = scanner.nextLine();

        System.out.println("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Transaction payment = new Transaction("Payment", description, -amount);

        System.out.println("Payment of $" + amount + " added with description: " + description);
    }

    private static void displayLedger() {
        System.out.println("Displaying the Ledger");
    }

}
