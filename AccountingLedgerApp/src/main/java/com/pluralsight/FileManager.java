package com.pluralsight;


import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static final String fileName = "src/main/resources/transactions.csv";

    public static void saveTransaction(Transaction transaction) {
        try(FileWriter writer =new FileWriter(fileName, true)) {
            writer.write(String.format("%s|%s|%s|%.2f\n",
                    transaction.getDateTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount()
            ));
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

}
