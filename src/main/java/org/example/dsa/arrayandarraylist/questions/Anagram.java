package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Anagram {
    /*
    * https://leetcode.com/problems/valid-anagram/description/
    * Example 1:
         Input: s = "anagram", t = "nagaram"
         Output: true
     Example 2:
         Input: s = "rat", t = "car"
         Output: false
    * */
    public static void main(String[] args) {
        String first = "rat";
        String second = "crt";
        log.info("The {} and {} are anagram? {}", first, second, isAnagram(first, second));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sCharArray = s.toCharArray();
        log.info("s before sort {}", sCharArray);
        Arrays.sort(sCharArray);
        log.info("s after sort {}", sCharArray);
        char[] tCharArray = t.toCharArray();
        log.info("t before sort {}", tCharArray);
        Arrays.sort(tCharArray);
        log.info("t after sort {}", tCharArray);
        return Arrays.compare(sCharArray, tCharArray) == 0;
    }
}
