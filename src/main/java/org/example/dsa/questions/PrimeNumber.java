package org.example.dsa.questions;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(checkPrimeNumber(new Scanner(System.in).nextInt()));
    }

    private static boolean checkPrimeNumber(int number) {
        if (number <= 1)
            return false;
        if (number == 2)
            return true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
