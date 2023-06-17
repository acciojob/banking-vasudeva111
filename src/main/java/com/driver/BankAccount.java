package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private int accountNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance=balance;
        this.minBalance=minBalance;
        this.accountNumber=accountNumber;
    }

    public int generateAccountNumber(int digits, int sum) throws Exception {
        if (sum > 9 * digits || sum < 0) {
            throw new Exception("Account Number can not be generated");
        }
        return this.accountNumber = generateAccountNumberHelper(digits, sum, 0);
    }

    private int generateAccountNumberHelper(int digits, int sum, int currentNumber) {
        if (digits == 0) {
            return currentNumber;
        }
        for (int i = 0; i <= 9; i++) {
            if (sum - i >= 0 && sum - i <= 9 * (digits - 1)) {
                int newNumber = currentNumber * 10 + i;
                int result = generateAccountNumberHelper(digits - 1, sum - i, newNumber);
                if (result != -1) {
                    return result;
                }
            }
        }
        return -1;
    }



    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance - amount <this.minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.balance -=amount;
    }

}