package org.example.neetcode150.twopointer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidPalindrome {

    /*Q:https://leetcode.com/problems/valid-palindrome/description/
    * 125. Valid Palindrome
    * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
        Given a string s, return true if it is a palindrome, or false otherwise.
        Example 1:

        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.
        Example 2:

        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.

        NOTE: consists only of printable ASCII characters.
    * */


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        log.info("is palindrome via Reverse String: {}", isPalindromeViaReversingString(s));
        log.info("is palindrome via Two Pointer: {}", isPalindromeViaTwoPointer(s));
    }

    /*Approach: 01 reverse the string after removal of the nonAlphanumeric and compare*/
    /*
     * 1. string converting to lowercase use a StringBuilder to create a new string which has only the alphanumeric
     * 2. reverse the result using new string(as it modify the same reference which result True always for comparison) string and compare with result if match return true else false
     * */
    public static boolean isPalindromeViaReversingString(String s) {
        s = s.toLowerCase();
        StringBuilder stringOnlyAlphanumeric = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) /*to check the alphanumeric*/
                stringOnlyAlphanumeric.append(c); /*new string bilded will have only small case for comparison*/
        }
        /*creating new stringBuilder to store reverse as if i call reverse on the same builder it will modify the same object which makes the comparison always true*/
        StringBuilder stringForReverse = new StringBuilder(stringOnlyAlphanumeric);
        return stringOnlyAlphanumeric.compareTo(stringForReverse.reverse()) == 0;
    }
    /*
     * TIME: O(n) --> we traversed each character
     * SPACE: O(n) --> String Builder cost the space
     * */

    /*Approach: 02 use the 2 pointer approach*/
    /*
     * 1. convert string to array initialize the i=0 and j= n-1 as first and last pointers
     * 2. if any i or j find non-alphanumeric just skip and go ahead (i++ or j--) via while
     * 3. if i and j are alphanumeric check for the equality with ignore case if not matches return false
     * 4. if it comes to end return true
     * */

    public static boolean isPalindromeViaTwoPointer(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!Character.isLetterOrDigit(charArray[i]) && i < j) /*if any non-alphanumeric character skip that*/
                i++;
            while (!Character.isLetterOrDigit(charArray[j]) && i < j)/*if any non-alphanumeric character skip that*/
                j--;
            if (Character.toLowerCase(charArray[i]) != Character.toLowerCase(charArray[j]))  /*when i and j on alphanumeric char then they should match else it is not a palindrome*/
                return false;
            /*move to next places*/
            i++;
            j--;
        }
        return true;
    }
    /*
     * TIME:O(n/2) -> O(n)
     * SPACE: O(1) --> no extra space is used
     * */

}
