package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    private static final double MINIMUM_BALANCE = 5000;
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,MINIMUM_BALANCE);
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId= tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(isVaildLicenseID(this.tradeLicenseId)){
            return;
        }
        else{
            this.tradeLicenseId = generateVaildId(this.tradeLicenseId);
        }
    }
    private boolean isVaildLicenseID(String id){
        for(int i=0;i<id.length();i++){
            if(id.charAt(i)==id.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
    private String generateVaildId(String id) throws Exception{
        char[] chars = id.toCharArray();
        Arrays.sort(chars);
        for(int i=1;i<chars.length;i++){
            if(chars[i]!=chars[i-1]){
                return new String(chars);
            }
        }
        throw new Exception("Valid License can not be generated");
    }

}