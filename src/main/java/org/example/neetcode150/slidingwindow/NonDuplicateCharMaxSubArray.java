package org.example.neetcode150.slidingwindow;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class NonDuplicateCharMaxSubArray {

    /*Q: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    3. Longest Substring Without Repeating Characters
        Given a string s, find the length of the longest substring without duplicate characters.

        Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

        Example 2:
        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
     */

    public static void main(String[] args) {
        String s = "abcabcbb";
        log.info("The max subString possible from {} is {} via BrutForce", s, lengthOfLongestSubstringViaBrutForce(s));
        log.info("The max subString possible from {} is {} via SlidingWindow", s, lengthOfLongestSubstringViaSlidingWindow(s));
        log.info("The max subString possible from {} is {} via SlidingWindow with map for optimal jump", s, lengthOfLongestSubstringViaSlidingWindowOptimalViaMap(s));
    }

    /*Approach: 01 BrutForce
    1. create a empty set
    2. iterate from each i and find max substring possible from that point
    3. we will check for distinct chars if it is then add it to the substring
    4. else end the substring cal for the i there and update the max count if current set is greater than that
    5. at the end return the result
    * */
    public static int lengthOfLongestSubstringViaBrutForce(String s) {
        int maxSubArrayWithoutDuplicate = 0;/*holds the max value */
        Set<Character> res = new HashSet<>();/*to check the duplicates and store the max substring*/

        for (int i = 0; i < s.length(); i++) {
            res.add(s.charAt(i));/*starting of the substring */
            for (int j = i + 1; j < s.length(); j++) {/*from i to till we get the distinct chars as a substring*/
                if (!res.contains(s.charAt(j)))/*if it is distinct add it to the substring*/
                    res.add(s.charAt(j));
                else /*if not end the substring cal and update the max substring found till this point and current sub string starting from i */
                    break;
            }
            maxSubArrayWithoutDuplicate = Math.max(maxSubArrayWithoutDuplicate, res.size());
            res = new HashSet<>();/*for each position i we are cal the max substring from that point so reset the set*/
        }
        return maxSubArrayWithoutDuplicate;
    }

    /*
     * TIME: O(n2) --> iteration of the string for each char to each possible max substring
     * SPACE: O(m) -> m is distinct chars in that string
     * */

    /*
     * Approach: 02 Sliding Window
     * 1. if it is empty or a single char string return it's length
     * 2. now set the min window starting from 0 only 1 index window so we added it as a substring
     * 3. while window doesn't reach end of the string check next char at 1 (r) is present in the substring if it is not just add it as a substring and move the right boundary
     * 4. if it is a duplicate char just remove the elements(l from starting to till we don't have duplicates) from the substring starting to  till we don't have any duplicate wrt current char(r)
     *    by sinking the left boundary l
     * 5. update the max if the new substring has > length
     * */
    public static int lengthOfLongestSubstringViaSlidingWindow(String s) {
        if (s.length() <= 1)
            return s.length();

        int maxSubArrayWithoutDuplicate = 0;
        int l = 0; /*start of the window*/
        int r = 1; /*end of the sliding window*/
        HashSet<Character> subString = new HashSet<>();

        subString.add(s.charAt(l));
        while (r < s.length()) {/* till right boundary reaches the end of the string*/
            if (!subString.contains(s.charAt(r))) {/*if it is a distinct char add it to the substring */
                subString.add(s.charAt(r));
                r++;/* extend the right boundary*/
            } else { /* if there is a duplicate remove all the starting char from the substring till we don't have any duplicates */
                while (l < s.length() && subString.contains(s.charAt(r))) {
                    subString.remove(s.charAt(l));
                    l++;/* shrink the left boundary till we don't have any duplicates*/
                }
            }
            maxSubArrayWithoutDuplicate = Math.max(maxSubArrayWithoutDuplicate, subString.size());/*update the max if it is greater than the previous max substring*/
        }
        return maxSubArrayWithoutDuplicate;
    }
    /*
     * TIME: O(n) --> using a window which traverse start to end at once even we use the while inside it is moving fwd only no repeated iteration
     * SPACE: O(m) --> m is distinct chars in the string
     * */

    /*Approach: 03: Sliding window with Map for optimal Jumps
     * 1. create a map which stores the latest index/last index of the char
     * 2. if the current character present in the map update the left index post that index
     * 3. update latest index if the char is duplicate else add new entry for that in the map
     * 4. update the max substring via formula r - l + 1
     * */

    public static int lengthOfLongestSubstringViaSlidingWindowOptimalViaMap(String s) {
        if (s.length() <= 1)
            return s.length();
        int maxSubArrayWithoutDuplicate = 0;
        int l = 0; /*start of the window*/
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (indexMap.containsKey(ch)) /* If duplicate is inside current window, jump left pointer */
                l = Math.max(l, indexMap.get(ch) + 1);
            indexMap.put(ch, r); /* Store latest index of current character*/
            maxSubArrayWithoutDuplicate = Math.max(maxSubArrayWithoutDuplicate, r - l + 1); /*Current window length is [l..r] +1 because 0 indexed*/
        }
        return maxSubArrayWithoutDuplicate;
    }

    /*
     * TIME: O(n) --> using a window which traverse start to end at once
     * SPACE: O(m) --> m is distinct chars in the string
     * */
}
