package org.example.patternVice.slidingWindow.dynamicWindow;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class LongestRepeatingCharWithReplacementOfKChar {

    /*
     * Q:https://leetcode.com/problems/longest-repeating-character-replacement/description/
     *424. Longest Repeating Character Replacement
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
*
Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
*
Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
     *
     * */
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        log.info("The longest substring with repeating char with k replacement is {}", characterReplacement(s, k));
    }

    /*
     * Approach:
     * 1. start = 0 maxFre = 0 map for freq of each char keep track of maxFre count int he current window
     * 2. if if window is valid (if windowLength - maxFreqCount <= k) nothing just expand else
     * 3. if windowLength - maxFreqCount > k then we need to shrink from the start till it becomes valid
     * 4. update the maLength by window size
     * */

    /*
     * T: O(n)
     * S: O(1) --> O(26) //max 26 alphabets
     * */
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int start = 0;
        int maxFreCharInWindow = 0;
        int maxLength = 0;
        HashMap<Character, Integer> windowCharFreMap = new HashMap<>();/*U can use int[26] and use it as a freq array for better memory*/

        for (int end = 0; end < len; end++) {
            char currentCha = s.charAt(end);
            windowCharFreMap.put(currentCha, windowCharFreMap.getOrDefault(currentCha, 0) + 1);
            maxFreCharInWindow = Math.max(maxFreCharInWindow, windowCharFreMap.get(currentCha));

            /*if nonrepeating char length is > k then shrink the window from start
             * nonRepeatingChar = windowLength - maxFreqCharInTheWindow if this is > k we can't replace them so shrink
             * */
            if ((end - start + 1) - maxFreCharInWindow > k) {
                windowCharFreMap.put(s.charAt(start), windowCharFreMap.get(s.charAt(start)) - 1);
                if (windowCharFreMap.get(s.charAt(start)) == 0)
                    windowCharFreMap.remove(s.charAt(start));
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
