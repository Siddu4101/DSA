package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberOfEvenDigitsNumbersInAnArray {
    /*
     * Q:https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
     *1295. Find Numbers with Even Number of Digits
        Given an array nums of integers, return how many of them contain an even number of digits.

        Example 1:
        Input: nums = [12,345,2,6,7896]
        Output: 2
        Explanation:
        12 contains 2 digits (even number of digits).
        345 contains 3 digits (odd number of digits).
        2 contains 1 digit (odd number of digits).
        6 contains 1 digit (odd number of digits).
        7896 contains 4 digits (even number of digits).
        Therefore only 12 and 7896 contain an even number of digits.

        Example 2:
        Input: nums = [555,901,482,1771]
        Output: 1
        Explanation:
        Only 1771 contains an even number of digits.
     * */
    public static void main(String[] args) {
        int[] nums = new int[]{12, 345, 2, 6, 7896};
        log.info("The number of even digits numbers in a given array is {}", findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        /*
         * Approach
         * a. to get the number of digits in a number is = floor(log10(number)) + 1
         * */
        int count = 0;
        for (int num : nums) {
            if ((Math.floor(Math.log10(num)) + 1) % 2 == 0)
                count++;
        }
        return count;
    }
}
