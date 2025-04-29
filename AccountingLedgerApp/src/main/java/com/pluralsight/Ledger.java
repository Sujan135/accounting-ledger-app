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
            System.out.println("H) Home");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    displayAll();
                    break;
                case "D":
                    break;
                case "P":
                    break;
                case "H":
                    break;
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

}
