package com.driver;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
        if(balance<500)
            throw new Exception("Insufficient Balance" );

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!check(tradeLicenseId)){
            String NewId= makeDifferId(tradeLicenseId);
            if(NewId.length()==0)
                throw new Exception("Valid License can not be generated");
            else
                tradeLicenseId=NewId;
        }



    }
    public boolean check(String id){

        for(int i=0;i<id.length()-1;i++){
            if(id.charAt(i)==id.charAt(i+1))
                return false;
        }
        return true;
    }

    public String makeDifferId(String S){

        int[] counts = new int[26];
        for (char ch : S.toCharArray()) {
            counts[ch - 'a'] += 1;
        }

        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return a2[0] - a1[0];
            }
        };
        int limit = (S.length()+ 1)/2;
        PriorityQueue<int[]> pq = new PriorityQueue(comp);
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count > limit)
                return "";
            if(count > 0)
                pq.add(new int[] {count, 'a' + i});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            //in this case we use most frequent char
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != (char)cur[1]) {
                sb.append((char)cur[1]);
                if (cur[0] > 1) {
                    cur[0] -= 1;
                    pq.add(cur);
                }
                //if most frequent one has been used previously - use next one from the min heap
            } else {
                int[] p = pq.poll();
                sb.append((char)p[1]);
                if (p[0] > 1) {
                    p[0] -= 1;
                    pq.add(p);
                }
                //put back most frequent one for next iterations
                pq.add(cur);
            }
        }
        return sb.toString();
    }
}