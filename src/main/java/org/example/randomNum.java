package org.example;

import java.util.Random;

public class randomNum {

    public static String generateValidTenDigitNumber() {
        Random random = new Random();

        // First digit should be between 0–5
        int firstDigit = 1 + random.nextInt(5); // 0 to 5

        // Generate the remaining 9 digits (each 0–9)
        StringBuilder number = new StringBuilder();
        number.append(firstDigit);
        for (int i = 0; i < 9; i++) {
            number.append(random.nextInt(10)); // 0 to 9
        }

        return number.toString();
    }

    public static void main(String[] args) {
        // Generate and print the random number
        String randomNumber = generateValidTenDigitNumber();
        System.out.println("Random 10-digit number: " + randomNumber);
    }


}
