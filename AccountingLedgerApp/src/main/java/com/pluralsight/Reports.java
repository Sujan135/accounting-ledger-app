package com.pluralsight;

import java.time.LocalDate;
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
                    forMonthToDate();
                    break;
                case "2":
                    forPreviousMonth();
                    break;
                case "3":
                    forYearToDate();
                    break;
                case "4":
                    forPreviousYear();
                    break;
                case "5":
                    searchByVendor(scanner);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }


    private  void forMonthToDate() {
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();

        System.out.println("Transactions for this month:");

        for (Transaction transaction : transactions){
            LocalDate transactionDate = transaction.getDate();

            if (transactionDate.getMonthValue() == currentMonth &&
                transactionDate.getYear() == currentYear) {
                System.out.println(transaction);
            }
        }
    }

    private void forPreviousMonth() {
        LocalDate today = LocalDate.now();
        LocalDate previousMonth = today.minusMonths(1);

        int previousMonthValue = previousMonth.getMonthValue();
        int previousYear = previousMonth.getYear();

        System.out.println("Transactions from previous month:");

        for (Transaction transaction : transactions){
            LocalDate date = transaction.getDate();
            if (date.getMonthValue() == previousMonthValue &&
                date.getYear() == previousYear) {
                System.out.println(transaction);
            }
        }
    }

    private void forYearToDate() {
        int currentYear = LocalDate.now().getYear();

        System.out.println("Transactions from this year:");

        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == currentYear){
                System.out.println(transaction);
            }
        }
    }

    private void forPreviousYear() {
        int previousYear = LocalDate.now().getYear() -1;

        System.out.println("Transactions from previous year:");

        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == previousYear) {
                System.out.println(transaction);
            }
        }
    }

    private void searchByVendor(Scanner scanner) {
        System.out.println("Enter vendor name to search: ");
        String vendorName = scanner.nextLine().toLowerCase();

        boolean found = false;

        System.out.println("Transactions for vendor: " + vendorName);

        for (Transaction transaction : transactions){
            if (transaction.getVendor().toLowerCase().equals(vendorName)){
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found){
            System.out.println("No transaction found for vendor: " + vendorName);
        }
    }

}
