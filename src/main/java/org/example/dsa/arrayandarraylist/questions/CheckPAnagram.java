package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckPAnagram {
    /*
     * Q:https://leetcode.com/problems/check-if-the-sentence-is-pangram/
     *  A pangram is a sentence where every letter of the English alphabet appears at least once.
        Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
        Example 1:
        Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
        Output: true
        Explanation: sentence contains at least one of every letter of the English alphabet.
        Example 2:
        Input: sentence = "leetcode"
        Output: false
     * */
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        log.info("given string is a pAnagram ? {}", checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        int[] alphabets = new int[26];
        for (int a : sentence.toCharArray()) {
            alphabets[a - 'a']++;
        }
        for (int b : alphabets) {
            if (b == 0)
                return false;
        }
        return true;
    }
}
