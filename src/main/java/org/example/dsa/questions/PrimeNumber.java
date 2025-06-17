package org.example.dsa.questions;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(checkPrimeNumber(new Scanner(System.in).nextInt()));
    }

    /*
        If a number N is not prime, it can be expressed as the product of two factors: [ N = a times b ] Now,
        if both a and b were greater than sqrt(N), their product would exceed N. This means that at least
        one of the factors must be less than or equal to sqrt(N).
    */
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
