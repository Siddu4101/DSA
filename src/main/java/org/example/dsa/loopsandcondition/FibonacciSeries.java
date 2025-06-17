package org.example.dsa.loopsandcondition;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        /*0,1,1,2,3,5,8.... sum of last 2 numbers*/
        /*get the n to print those many numbers of this series*/

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printNFibonacciSeriesNumbers(n);
    }

    private static void printNFibonacciSeriesNumbers(int n) {
        /*seeds*/
        int a = 0;
        int b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int nextVal = a + b;
            System.out.print(nextVal + " ");
            a = b;
            b = nextVal;
        }

    }
}
