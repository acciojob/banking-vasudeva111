package com.driver;

public class StudentAccount extends BankAccount{
    private static final double MINIMUM_BALANCE = 0;
    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name,balance,MINIMUM_BALANCE);
        this.institutionName =institutionName;
    }

}