package org.example.dsa.loopsandcondition;

import java.util.Scanner;

public class CheckTheCharacterIsUpperCaseOrLowerCase {
    /*a-z --> 97 - 122*/
    /*A-Z --> 65 - 90*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char inputChar = scanner.next().trim().charAt(0);
        checkIsCapitalLetter(inputChar);
        checkIsCapitalLetterSecondWay(inputChar);
    }

    static void checkIsCapitalLetter(int ch) {
        if (ch >= 65 && ch <= 90)
            System.out.println("character " + (char) ch + " is a capital letter");
        else if (ch >= 97 && ch <= 122)
            System.out.println("character " + (char) ch + " is a small letter");
        else
            System.out.println("character " + (char) ch + " is not a valid alphabet");
    }

    static void checkIsCapitalLetterSecondWay(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            System.out.println("character " + ch + " is a capital letter");
        else if (ch >= 'a' && ch <= 'z')
            System.out.println("character " + ch + " is a small letter");
        else
            System.out.println("character " + ch + " is not a valid alphabet");
    }
}
