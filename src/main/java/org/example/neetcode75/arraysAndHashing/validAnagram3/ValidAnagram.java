package org.example.neetcode75.arraysAndHashing.validAnagram3;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

@Slf4j
public class ValidAnagram {
/*
* Q:https://leetcode.com/problems/valid-anagram/description/

242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

NOTE: s and t consist of lowercase English letters.
* */

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        log.info("Via sort: {}", isAnagramViaSort(s, t));
        log.info("Via frequency array: {}", isAnagramViaFrequencyArray(s, t));
        log.info("Via frequency hashMap: {}", isAnagramViaFrequencyHashMap(s, t));
    }

    /*Approach:01
     * T: O(nlogn + mlogm)
     * S: O(1)
     * */
    private static boolean isAnagramViaSort(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    /*Approach: 02
     * T: O(n)
     * S: O(1)
     * */
    private static boolean isAnagramViaFrequencyArray(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }
        for (int a : alphabets) {
            if (a != 0)
                return false;
        }
        return true;
    }


    /*Approach: 03
     * T: O(n)
     * S: O(1)
     * */
    private static boolean isAnagramViaFrequencyHashMap(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> sAlphabets = new HashMap<>();
        HashMap<Character, Integer> tAlphabets = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sAlphabets.put(s.charAt(i), sAlphabets.getOrDefault(s.charAt(i), 0) + 1);
            tAlphabets.put(t.charAt(i), tAlphabets.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sAlphabets.equals(tAlphabets);
    }


}
