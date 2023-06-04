package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;

    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        if(amount>maxWithdrawalLimit)
            throw new Exception("Maximum Withdraw Limit Exceed" );
        else if (amount>getBalance())
            throw new Exception("Insufficient Balance" );
        else{
            double newballance= (getBalance()-amount);
            setBalance(newballance);

        }

        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

    }

    public double getSimpleInterest(int years){
        double finalAmount = getBalance()*(1+(rate*years));
        return finalAmount;
        // Return the final amount considering that bank gives simple interest on current amount

    }

    public double getCompoundInterest(int times, int years){
        double power = times*years;
        double amount = getBalance()*(1+(rate/times));
        double finalAmount = Math.pow(amount,power);
        return finalAmount;
        // Return the final amount considering that bank gives compound interest on current amount given times per year

    }

}