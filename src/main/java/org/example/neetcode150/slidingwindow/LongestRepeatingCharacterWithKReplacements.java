package org.example.neetcode150.slidingwindow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestRepeatingCharacterWithKReplacements {

    /*Q: https://leetcode.com/problems/longest-repeating-character-replacement/description/
        424. Longest Repeating Character Replacement
        You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
        Return the length of the longest substring containing the same letter you can get after performing the above operations.

        Example 1:
        Input: s = "ABAB", k = 2
        Output: 4
        Explanation: Replace the two 'A's with two 'B's or vice versa.

        Example 2:
        Input: s = "AABABBA", k = 1
        Output: 4
        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        The substring "BBBB" has the longest repeating letters, which is 4.
        There may exist other ways to achieve this answer too.
     * */

    public static void main(String[] args) {
        String s = "AAABABBA";//"ABBB";
        int k = 2;
        log.info("The max length of the single element with replacement is {} via BrutForce", characterReplacement(s, k));
        log.info("The max length of the single element with replacement is {} via BrutForce", characterReplacementTest(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int originalK = k;
        int firstNonMatch = 0;
        int maxRepeatedCharLength = 0;

        /*left to right*/
        while (j < s.length()) {
            while (j < s.length() && s.charAt(i) == s.charAt(j))
                j++;

            if (k == originalK)
                firstNonMatch = j;

            if (k > 0 && j < s.length()) {
                if (s.charAt(i) != s.charAt(j)) {
                    k--;
                }
                j++;
            }

            maxRepeatedCharLength = Math.max(maxRepeatedCharLength, j - i);
            if (k == 0 && j < s.length() && s.charAt(i) != s.charAt(j)) {
                i = firstNonMatch;
                j = i + 1;
                k = originalK;
            }
        }

        /*right to left*/
        i = s.length() - 1;
        j = i - 1;
        while (j >= 0) {
            while (j >= 0 && s.charAt(i) == s.charAt(j))
                j--;

            if (k == originalK)
                firstNonMatch = j;

            if (k > 0 && j >= 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    k--;
                }
                j--;
            }

            maxRepeatedCharLength = Math.max(maxRepeatedCharLength, i - j);
            if (k == 0 && j >= 0 && s.charAt(i) != s.charAt(j)) {
                i = firstNonMatch;
                j = i - 1;
                k = originalK;
            }
        }

        return maxRepeatedCharLength;
    }


    public static int characterReplacementTest(String s, int k) {
        int i = 0;
        int j = 1;
        int l = s.length();
        int firstFailure = 0;
        int res = 1;
//        AAABABBA
        while (j < l) {
            StringBuilder copyOfS = new StringBuilder(s);
            if (firstFailure < l - 1) {
                i = firstFailure;
                j = i + 1;
            } else {
                break;
            }
            while (i < l - 1) {
                while (j < l) {
                    if (copyOfS.charAt(i) == copyOfS.charAt(j) && j < l) {
                        i++;
                        j++;
                    } else if (copyOfS.charAt(i) != copyOfS.charAt(j) && k > 0 && j < l) {
                        if (firstFailure == 0)
                            firstFailure = j;
                        copyOfS.replace(j, j + 1, String.valueOf(copyOfS.charAt(j)));
                        i++;
                        j++;
                        k--;
                    } else {
                        i = l - 1;
                        j = l;
                    }

                    res = Math.max(res, j - i + 1);
                }
            }

        }
        return res;
    }

}
