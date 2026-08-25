package org.example.patternVice.slidingWindow.dynamicWindow;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class LongestSubStringWithoutRepeatingChar {

    /*
    * Q: https://leetcode.com/problems/longest-substring-without-repeating-characters/
    *
    * 3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
*
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.*/


    public static void main(String[] args) {
        String s = "bbbbb";//"abcabcbb";
        log.info("max length substring from {} is {}", s, lengthOfLongestSubstring(s));
        log.info("max length substring optimized from {} is {}", s, lengthOfLongestSubstringOptimized(s));
    }

    /*
     * T: O(n)
     * S: O(1)
     * */
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        HashMap<Character, Integer> charFreMp = new HashMap<>(); /*char freq*/

        for (int i = 0; i < s.length(); i++) {
            charFreMp.put(s.charAt(i), charFreMp.getOrDefault(s.charAt(i), 0) + 1); /* add new char to window*/

            while (charFreMp.get(s.charAt(i)) > 1) { /*if any char got duplicate*/
                charFreMp.put(s.charAt(start), charFreMp.get(s.charAt(start)) - 1); /* shrink from start of window till no duplicate*/
                if (charFreMp.get(s.charAt(start)) == 0) /* once 0 elements for a char in map remove it from the window/map*/
                    charFreMp.remove(s.charAt(start));
                start++;/* move start of the window to remove duplicate from the window*/
            }

            maxLength = Math.max(maxLength, i - start + 1);/* update max*/
        }
        return maxLength;
    }


    /*
     * T: O(n)
     * S: O(1)
     * */
    public static int lengthOfLongestSubstringOptimized(String s) {
        int start = 0;
        int maxLength = 0;
        HashMap<Character, Integer> charFreMp = new HashMap<>(); /*char freq*/

        for (int i = 0; i < s.length(); i++) {
            if (charFreMp.containsKey(s.charAt(i)))  /*if any char duplicate*/
                start = Math.max(start, charFreMp.get(s.charAt(i)) + 1); /*the last index at which this element is already present +1 to remove it from window */

            charFreMp.put(s.charAt(i), i); /* add new char to window*/
            maxLength = Math.max(maxLength, i - start + 1);/* update max by re,moving element till where we have existing duplicate char*/
        }
        return maxLength;
    }
}
