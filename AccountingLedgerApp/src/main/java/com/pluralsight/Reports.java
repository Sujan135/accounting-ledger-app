package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Reports {
    private ArrayList<Transaction> transactions;

    public Reports(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void displayReportMenu (Scanner scanner) {
        while (true) {
            System.out.println("\nReports Menu:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

}
