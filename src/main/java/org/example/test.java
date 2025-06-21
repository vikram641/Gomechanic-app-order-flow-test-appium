package org.example;

import org.bson.Document;

import static org.example.mongoOps.findNumber;

public class test {
    public static void main(String[] args){

        String otp = mongoOps.getOtpByPhone("2255122551");
        String a = String.valueOf(otp.charAt(0));
        String b = String.valueOf(otp.charAt(1));
        String c = String.valueOf(otp.charAt(2));
        String d = String.valueOf(otp.charAt(3));


        System.out.println(a); // V
        System.out.println(b); // i
        System.out.println(c); // k
        System.out.println(d); // a






    }


}
