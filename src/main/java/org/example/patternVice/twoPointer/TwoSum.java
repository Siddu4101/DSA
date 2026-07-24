package org.example.patternVice.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;


@Slf4j
public class TwoSum {
        /*
     * Q:https://leetcode.com/problems/two-sum/description/
     * 1. Two Sum
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.

        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]

        Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
     * */

    public static void main(String[] args) {
        int[] input = {1, 2, 4};
        int target = 6;
        log.info("The index's which makes target is {} via Two Pointer", twoSumViaTwoPointer(input, target));
        log.info("The index's which makes target is {} via HashMap", twoSumViaHashMap(input, target));
    }


    /*
     * T: O(n) -- traversed the whole array
     * S: O(1) -- constant space as no extra space used
     * */
    private static int[] twoSumViaTwoPointer(int[] input, int target) {
        int[] noIndexMakesSum = {-1, -1};
        if (input.length < 2)
            return noIndexMakesSum;

        int start = 0;
        int end = input.length - 1;

        while (start < end) {
            int sum = input[start] + input[end];
            if (sum == target)
                return new int[]{start, end};
            else if (sum > target)
                end--;
            else
                start++;
        }
        return noIndexMakesSum;
    }

    /*EXTRA*/
    /*
     * T: O(n) -- single pass through the array
     * S: O(n) -- extra space for the hashmap
     * */
    static int[] twoSumViaHashMap(int[] input, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int complement = target - input[i];
            if (hashMap.containsKey(complement))
                return new int[]{hashMap.get(complement), i};
            hashMap.put(input[i], i);
        }
        return new int[]{-1, -1};
    }
}
