package org.example.dsa.questions;

import java.util.Scanner;

public class FindTheGreatestNumberAmongThree {
    public static void main(String[] args) {
        /*get 3 number as input*/
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        System.out.println("max number in the given " + num1 + " " + num2 + " " + num3 + " is " + getMaxFirstWay(num1, num2, num3));
        System.out.println("max number in the given " + num1 + " " + num2 + " " + num3 + " is " + getMaxSecondWay(num1, num2, num3));
        System.out.println("max number in the given " + num1 + " " + num2 + " " + num3 + " is " + getMaxThirdWay(num1, num2, num3));
        System.out.println("max number in the given " + num1 + " " + num2 + " " + num3 + " is " + Math.max(num3, Math.max(num1, num2)));
    }

    static int getMaxFirstWay(int num1, int num2, int num3) {
        if (num1 > num2) {
            if (num1 > num3) {
                return num1;
            } else {
                return num3;
            }
        } else {
            if (num2 > num3)
                return num2;
            else
                return num3;
        }
    }

    static int getMaxSecondWay(int num1, int num2, int num3) {
        if (num1 > num2 && num1 > num3)
            return num1;
        else if (num2 > num1 && num2 > num3)
            return num2;
        else
            return num3;
    }

    static int getMaxThirdWay(int num1, int num2, int num3) {
        int max = num1;

        if (num2 > max)
            max = num2;
        if (num3 > max)
            max = num3;

        return max;
    }
}
