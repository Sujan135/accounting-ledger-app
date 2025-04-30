package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime dateTime;
    private String description;
    private String vendor;
    private double amount;


    public Transaction(LocalDateTime dateTime, String description, String vendor, double amount ) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        return  dateTime.format(formatter) + "|" + description + "|" + vendor + "|" + amount;
    }
}
