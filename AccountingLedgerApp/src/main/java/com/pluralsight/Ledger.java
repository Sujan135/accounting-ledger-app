package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    private ArrayList<Transaction> transactions;

    public Ledger(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nLedger Menu:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    displayAll();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void displayAll() {
        System.out.println("All Transactions:");
        for (int i = transactions.size()-1; i >= 0; i--){
            System.out.println(transactions.get(i));
        }
    }

    private void displayDeposits() {
        System.out.println("Deposits Only");
        for (int i = transactions.size() -1 ; i >= 0; i--) {
            if (transactions.get(i).getAmount() > 0) {
                System.out.println(transactions.get(i));
            }
        }
    }

    private void displayPayments() {
        System.out.println("Payments Only:");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            if (transactions.get(i).getAmount() < 0) {
                System.out.println(transactions.get(i));

            }
        }
    }

}
