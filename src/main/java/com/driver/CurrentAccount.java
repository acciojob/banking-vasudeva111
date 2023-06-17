package com.driver;

import java.util.Arrays;
import java.util.ArrayList;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name,balance,5000.0);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < getMinBalance()){
            throw new Exception("Insufficient Balance");
        }
    }
    public String swap(String a,int i,int j){
        char temp;
        char[] ch= a.toCharArray();
        temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return String.valueOf(ch);

    }


    private void permute (String str,int l,int r,ArrayList<String>ans){

        if(l == r){
            ans.add(str);
        }
        else{
            for(int i =1;i<=r;i++){
                str = swap(str,l,i);
                permute(str,l+1,r,ans);
                str=swap(str,l,i);
            }
        }
    }


    // Driver's Code


    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        ArrayList<String> ans = new ArrayList<>();
        permute(getTradeLicenseId(),0,tradeLicenseId.length()-1,ans);
        boolean flag = false;
        boolean check = false;
        for(String str : ans){
            flag =false;
            for(int i=0;i<str.length()-1;i++){
                if(str.charAt(i)== str.charAt(i+1)){
                    flag =true;
                }
            }
            if(flag == false){
                check =true;
            }
            if(flag == false){
                check =true;
            }
        }
        if(check == false){
            throw new Exception("Valid License can not be generated");
        }
    }

}