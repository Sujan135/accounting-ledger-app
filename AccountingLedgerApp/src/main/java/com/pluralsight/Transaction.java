package com.pluralsight;

import java.time.LocalDate;

public class Transaction {
//    String type;
    private LocalDate date;
    private String description;
    private double amount;


    public Transaction(LocalDate date, String description,double amount ) {
//        this.type = type;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }



    public String toString(){
//        String type = (amount >= 0) ? "Deposit" : "Payment";
        return  date + "|" + description + " | " + amount;
    }
}
