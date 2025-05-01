package com.pluralsight;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class FileManager {
    private static final String filePath = "src/main/resources/transactions.csv";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");

    public static void saveTransaction(Transaction transaction) {
        try(FileWriter writer =new FileWriter(filePath, true)) {
            writer.write(String.format("%s|%s|%s|%.2f\n",
                    transaction.getDateTime().format(formatter),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount()
            ));
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    public static ArrayList<Transaction> loadTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return transactions;
        }

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                        LocalDateTime dateTime = LocalDateTime.parse(parts[0] + "|" + parts[1], formatter);
                        String description = parts[2];
                        String vendor = parts[3];
                        double amount = Double.parseDouble(parts[4]);

                        Transaction transaction = new Transaction(dateTime, description,vendor,amount);
                        transactions.add(transaction);

                    }
            }

        }catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }

        return transactions;

    }

}
