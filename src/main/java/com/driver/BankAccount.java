package com.driver;
// class UserException extends Exception {
//    public UserException(String s)
//    {
//        // Call constructor of parent Exception
//        super(s);
//    }
//}

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public int account;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        account=-1;
        String ans=null;
        makeAccount(0,digits,sum);
        if(account!=-1)
            ans= String.valueOf(account);


        if(ans == null){
            throw new Exception ("Account Number can not be generated");
        }
        else{
            return ans;
        }
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        if(balance-amount<minBalance)
            throw new Exception("Insufficient Balance");
        else
            balance-=amount;

        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
    }
    public void makeAccount(int ans,int digits,int sum){
        if(digits==0 && sum==0){
            account=ans;
            return ;
        }
        if(digits==0 && sum!=0)
            return ;
        if(digits!=0 && sum==0)
            return ;
        for(int i=0;i<=9;i++){
            makeAccount(ans*10+i,digits-1,sum-i);

        }

    }

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
}