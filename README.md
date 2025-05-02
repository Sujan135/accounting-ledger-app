# Accounting Ledger CLI Application

A **Java-based command-line application** that allows users to record, manage, and report financial transactions. This capstone project was built as part of the Java Development Fundamentals course, demonstrating real-world use of Java I/O, classes, conditionals, loops, and data parsing.

## 📁 Features

- ✅ **Add Deposit**: Log income transactions
- ✅ **Make Payment**: Track expenses or outgoing payments
- ✅ **View Ledger**:
  - View **All** transactions
  - Filter by **Deposits** only
  - Filter by **Payments** only
- ✅ **Generate Reports**:
  - Month to Date
  - Previous Month
  - Year to Date
  - Previous Year
  - Search by Vendor
- ✅ **CSV File Support**: Transactions are saved to and loaded from `transactions.csv`
- ✅ **User-Friendly CLI Navigation**
- ✅ **Exit Option**: Gracefully exit the application

## 📄 CSV Format

All transactions are stored in a file called `transactions.csv` in this format:

# Features
 •	Add Deposit: Record deposit transactions to track income.
 
•	Make Payment: Log expenses or payments to track spending.

 •	View All Transactions: View the full ledger of deposits and payments.
 
 •	Filter by Type: View only deposits or only payments.
 
 •	Search by Vendor: Search for transactions related to a specific vendor.
 
 •	Generate Reports: Run reports for different time periods like "Month To Date", "Previous Year", etc.
 
 •	Save and Load from File: Transactions are saved to and loaded from a CSV file, ensuring persistence.
 
 •	Exit the Application: Exit the program smoothly.

# My Project

One interesting piece of code in this project is how I parsed a date and time value from a single input line and split it 
into usable parts using LocalDateTime.

# LocalDateTime dateTime = LocalDateTime.parse(parts[0] + "|" + parts[1], formatter);

# I read a date and time string from input like:
# "2025-04-24|17:54:11"

# I split it using parts[0] (date) and parts[1] (time), then recombined it with a pipe (|)


# Welcome to my project! Below is the testing image:

# FirstTesting
![First Testing Image](https://github.com/Sujan135/accounting-ledger-app/blob/e494537a09077df3b504f7158856f9121b973d81/firstTesting.jpg)

# SecondTesting
![Second Testing Image](https://github.com/Sujan135/capstone-1/blob/013f00b664355608c304da5a21254f5e8aee03cc/mySecondTesting(Ledger).jpg)

# Thirdtesting
![Third Testing Image](https://github.com/Sujan135/capstone-1/blob/5a5f6e7b8c39d569b77724cfc4f1df0567f48336/thirdtesting(vendor).jpg).

# FourthTesting
![Fourth Testing Image](https://github.com/Sujan135/capstone-1/blob/be2a460fc432293420714ec375e29c1e49997c5b/fourthTesting(reports).jpg).
