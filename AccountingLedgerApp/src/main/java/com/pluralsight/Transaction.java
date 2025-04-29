package com.pluralsight;

public class Transaction {
    String type;
    private String description;
    private double amount;

    public Transaction(String type ,String description, double amount) {
        this.type = type;
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String toString(){
//        String type = (amount >= 0) ? "Deposit" : "Payment";
        return type + ": $" + amount + " _ " + description;
    }
}
