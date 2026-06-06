package org.example.neetcode75.arraysAndHashing.twoSum;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

@Slf4j
public class TwoSum {
/*
*
Q: https://leetcode.com/problems/two-sum/description/

1. Two Sum

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
* */

    public static void main(String[] args) {
        int[] nums =
                {-3, 4, 3, 90};
//                {3, 2, 4};
//                {2, 7, 11, 15};
        int target =
                0;
//                6;
//                9;
        log.info("Via brutForce: {}", twoSumViaBrutForce(nums, target));
        log.info("Via 2 pointer: {}", twoSumViaTwoPointer(nums, target));
        log.info("Via hashmap : {}", twoSumViaHashMap(nums, target));
    }

    /*Approach: 1
     * Time: O(n2)
     * Space: O(1)
     * */
    private static int[] twoSumViaBrutForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    /*Approach: 2
     * Time: O(nlogn)
     * Space: O(n)
     * */
    private static int[] twoSumViaTwoPointer(int[] nums, int target) {
        int[][] indexedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i];
            indexedNums[i][1] = i;
        }
        log.info("Before sort: {}", Arrays.deepToString(indexedNums));
        Arrays.sort(indexedNums, (a, b) -> a[0] - b[0]);
        log.info("After sort: {}", Arrays.deepToString(indexedNums));
        int start = 0;
        int end = indexedNums.length - 1;
        while (start < end) {
            int sum = indexedNums[start][0] + indexedNums[end][0];
            if (sum == target)
                return new int[]{indexedNums[start][1], indexedNums[end][1]};
            else if (sum > target)
                end--;
            else
                start++;
        }
        return new int[]{-1, -1};
    }


    /*Approach:03
     * Time: O(n)
     * Space: O(n)
     * */
    private static int[] twoSumViaHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }


}