package com.pluralsight;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private String description;
    private String vendor;
    private double amount;


    public Transaction(LocalDate date, String description, String vendor, double amount ) {
        this.date = date;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }



    public String toString(){
//        String type = (amount >= 0) ? "Deposit" : "Payment";
        return  date + " | " + description + " | " + vendor + " | " + amount;
    }
}
