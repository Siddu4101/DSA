package org.example.dsa.loopsandcondition;

import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = scanner.nextLong();
        reverseTheNumber(number);
    }

    private static void reverseTheNumber(long number) {
        long result = 0;
        long numberForLog = number;
        while (number > 0) {
            long digit = number % 10;
            result = result * 10 + digit;
            number = number / 10;
        }
        System.out.println("reversed number of the " + numberForLog + " is " + result);
    }
}
