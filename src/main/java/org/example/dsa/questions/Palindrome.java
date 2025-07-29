package org.example.dsa.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Palindrome {
    public static void main(String[] args) {
        String word = "TATA";
        log.info("is word {} palindrome? ==> {}", word, palindrome(word));
    }

    private static boolean palindrome(String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0, j = word.length() - 1; i <= j; i++, j--) {
            if (charArray[i] != charArray[j])
                return false;
        }
        return true;
    }
}
