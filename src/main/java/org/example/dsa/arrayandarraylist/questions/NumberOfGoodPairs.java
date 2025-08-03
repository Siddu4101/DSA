package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberOfGoodPairs {

    /*
     * Q:https://leetcode.com/problems/number-of-good-pairs/
     *1512. Number of Good Pairs
        Solved
        Easy
        Topics
        premium lock icon
        Companies
        Hint
        Given an array of integers nums, return the number of good pairs.
        A pair (i, j) is called good if nums[i] == nums[j] and i < j.
        Example 1:
        Input: nums = [1,2,3,1,1,3]
        Output: 4
        Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
        Example 2:
        Input: nums = [1,1,1,1]
        Output: 6
        Explanation: Each pair in the array are good.
     *
     * */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 1, 3};
        log.info("The number of good pairs in a given array is {}", numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
        }
        return count;
    }
}
