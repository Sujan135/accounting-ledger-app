package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Reports {
    private final ArrayList<Transaction> transactions;

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
            System.out.println("6) Custom Search");
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
                case "6":
                    forCustomSearch(scanner);
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
            LocalDateTime transactionDateTime = transaction.getDateTime();

            if (transactionDateTime.getMonthValue() == currentMonth &&
                transactionDateTime.getYear() == currentYear) {
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
            LocalDateTime dateTime = transaction.getDateTime();
            if (dateTime.getMonthValue() == previousMonthValue &&
                dateTime.getYear() == previousYear) {
                System.out.println(transaction);
            }
        }
    }

    private void forYearToDate() {
        int currentYear = LocalDate.now().getYear();

        System.out.println("Transactions from this year:");

        for (Transaction transaction : transactions) {
            if (transaction.getDateTime().getYear() == currentYear){
                System.out.println(transaction);
            }
        }
    }

    private void forPreviousYear() {
        int previousYear = LocalDate.now().getYear() -1;

        System.out.println("Transactions from previous year:");

        for (Transaction transaction : transactions) {
            if (transaction.getDateTime().getYear() == previousYear) {
                System.out.println(transaction);
            }
        }
    }

    // Allow user to  search transactions based on vendor name
    private void searchByVendor(Scanner scanner) {
        System.out.println("Enter vendor name to search: ");
        String vendorName = scanner.nextLine().toLowerCase().trim();

        boolean found = false;

        System.out.println("Transactions for vendor: " + vendorName);

        for (Transaction transaction : transactions){
            if (transaction.getVendor().equalsIgnoreCase(vendorName)){
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found){
            System.out.println("No transaction found for vendor: " + vendorName);
        }
    }


    // Allow user to search item applying multiple filters
    private void forCustomSearch (Scanner scanner) {

        HashMap<String, String> filters = new HashMap<>();

        System.out.println("--- Custom Search ---");

        System.out.println("Start Date (yyyy-mm-dd): ");
        String startDate = scanner.nextLine().trim();
        filters.put("startDate", startDate.isEmpty() ? null : startDate);

        System.out.println("End Date (yyyy-mm-dd): ");
        String endDate = scanner.nextLine().trim();
        filters.put("endDate", endDate.isEmpty() ? null : endDate);

        System.out.println("Description: ");
        String description = scanner.nextLine().toLowerCase().trim();
        filters.put("description", description.isEmpty() ? null : description);

        System.out.println("Vendor: ");
        String vendor = scanner.nextLine().toLowerCase().trim();
        filters.put("vendor", vendor.isEmpty() ? null : vendor);

        System.out.println("Amount: ");
        String amount = scanner.nextLine().trim();
        filters.put("amount",amount.isEmpty() ? null : amount);

        boolean found = false;

        for (Transaction transaction : transactions) {

            boolean isMatch = true;

//            LocalDate transactionDate = transaction.getDateTime().toLocalDate();
//            This is useful when comparing or filtering transactions based on dates without considering the time.

            if (filters.get("startDate") !=null) {
                LocalDateTime transactionDateTime = transaction.getDateTime();
                LocalDate transactionDate = transactionDateTime.toLocalDate();
                LocalDate start = LocalDate.parse(filters.get("startDate"));
               if (transactionDate.isBefore(start)) {
                   isMatch = false;
               }
            }

            if (filters.get("endDate") !=null) {
                LocalDateTime transactionDateTime = transaction.getDateTime();
                LocalDate transactionDate = transactionDateTime.toLocalDate();
                LocalDate end = LocalDate.parse(filters.get("endDate"));
                if (transactionDate.isBefore(end)) {
                    isMatch = false;
                }
            }

            if (filters.get("description") != null) {
                String transactionDescription = transaction.getDescription().toLowerCase();
                String searchDescription = filters.get("description");
                if (!transactionDescription.contains(searchDescription)){
                    isMatch = false;
                }
            }
            if (filters.get("vendor") != null) {
                String transactionVendor = transaction.getVendor().toLowerCase();
                String searchVendor = filters.get("vendor");
                if (!transactionVendor.contains(searchVendor)){
                    isMatch = false;
                }
            }

            if (filters.get("amount") != null) {
                try {
                    double searchAmount = Double.parseDouble(filters.get("amount"));
                    double transactionAmount = transaction.getAmount();
                    if (transactionAmount != searchAmount) {
                        isMatch= false;
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Invalid amount format.");
                    isMatch = false;
                }
            }
             if (isMatch) {
                 System.out.println(transaction);
                 found = true;
             }
        }

        if (!found) {
            System.out.println("No transaction found matching");
        }
    }
}
