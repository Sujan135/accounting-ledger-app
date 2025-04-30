package com.pluralsight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Welcome to the Accounting Ledger!");
            System.out.println("Please select an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("x) Exit");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    addDeposit(scanner);
                    break;
                case "P":
                    makePayment(scanner);
                    break;
                case "L":
                    Ledger ledger = new Ledger(transactions);
                    ledger.displayMenu();
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

        System.out.println("Enter vendor name: ");
        String vendor = scanner.nextLine();

        Transaction deposit = new Transaction(LocalDateTime.now(), description, vendor,amount);
        transactions.add(deposit);

        System.out.println("Deposit of $" + amount + " with description: " + description);
    }

    // Created method for making a payment
    private static void makePayment(Scanner scanner) {
        System.out.println("Enter payment description: ");
        String description = scanner.nextLine();

        System.out.println("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter vendor name: ");
        String vendor = scanner.nextLine();

        Transaction payment = new Transaction(LocalDateTime.now(), description, vendor,-amount);
        transactions.add(payment);

        System.out.println("Payment of $" + amount + " with description: " + description);
    }

//    Displaying ledger
    private static void displayLedger() {
        System.out.println("Displaying the Ledger");
        if (transactions.isEmpty()) {
            System.out.println("No transaction recorded.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

}
