package org.example.neetcode150.arraysAndHashing;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

@Slf4j
public class TwoSum {
    /*
     * 3.https://leetcode.com/problems/two-sum/description/
     * 1. Two Sum
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.

        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:
        Input: nums = [3,3], target = 6
        Output: [0,1]
     * */
    public static void main(String[] args) {
        int[] nums = {3, 3};// {-10, -1, -18, -19};
        int target = 6;//-19;
        log.info("the target can be computed from the pos via brut force{}", Arrays.toString(twoSumViaBrutForce(nums, target)));
        log.info("the target can be computed from the pos via hashmap {}", Arrays.toString(twoSumViaHashMap(nums, target)));
    }

    private static int[] twoSumViaBrutForce(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumViaHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int diff = target - nums[j];
            if (hashMap.containsKey(diff))
                return new int[]{hashMap.get(diff), j};
            hashMap.put(nums[j], j);
        }
        return new int[]{};
    }
}
