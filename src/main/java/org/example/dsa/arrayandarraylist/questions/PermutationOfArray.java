package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PermutationOfArray {

    /*
     * Q:https://leetcode.com/problems/build-array-from-permutation/
     *`nput: nums = [0,2,1,5,3,4]
        Output: [0,1,2,4,5,3]
        Explanation: The array ans is built as follows:
        ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
        = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
        = [0,1,2,4,5,3]
     * */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 5, 3, 4};
        log.info("before permutation {} and after permutation {}", nums, buildArray(nums));
    }

    public static int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
//        System.gc();// this increases the space performance on LeetCode
        return result;
    }
}
