package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount b=new BankAccount("krisha",400,200);
        System.out.println(b.generateAccountNumber(9,9));
        CurrentAccount account1 = new CurrentAccount("Ram",10000.00,"abcddff");
        account1.validateLicenseId();
        System.out.println(account1.getTradeLicenseId());

        SavingsAccount account2 = new SavingsAccount("Sohan",5000.00,2000,15.6);
//        account2.withdraw(3000);
//        account2.withdraw(6000);

        account2.withdraw(1000);
        System.out.println(account2.getSimpleInterest(2));
        System.out.println(account2.getCompoundInterest(3,1));

        StudentAccount account3 = new StudentAccount("Raj Kumar",1000,"AccioJob");

        BankAccount account4 = new BankAccount("Kyle",1000,500);
        System.out.println(account4.generateAccountNumber(6,16));

    }
}