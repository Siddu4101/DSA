package org.example.neetcode150.arraysAndHashing;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ValidAnagram {
    /*
    * 2. https://leetcode.com/problems/valid-anagram/description/
    * Example 1:
         Input: s = "anagram", t = "nagaram"
         Output: true
     Example 2:
         Input: s = "rat", t = "car"
         Output: false
    * */
    public static void main(String[] args) {
        String first = "rat";
        String second = "tar";
        log.info("The {} and {} are anagram? via contains and replace methods {}", first, second, withoutSortingUsingContainsAndReplace(first, second));
        log.info("The {} and {} are anagram? via sortign and equals {}", first, second, isAnagram(first, second));
    }

    public static boolean isAnagram(String s, String t) {
        /*Here we will convert to char array and sort then compare them */
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

    private static boolean withoutSortingUsingContainsAndReplace(String s, String t) {
        /*Here i am replacing those are matching chars and at the end if we have empty string that means they had actual similar chars */
        if (s.length() != t.length())
            return false;

        for (char c : t.toCharArray()) {
            if (s.contains(String.valueOf(c)))
                s = s.replaceFirst(String.valueOf(c), "");
        }
        return s.isEmpty();
    }
}
