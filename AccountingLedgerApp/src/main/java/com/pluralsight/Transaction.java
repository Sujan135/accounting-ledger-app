package com.pluralsight;

public class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String toString(){
        String type = (amount >= 0) ? "Deposit" : "Payment";
        return type + ": $" + amount + " _ " + description;
    }
}
