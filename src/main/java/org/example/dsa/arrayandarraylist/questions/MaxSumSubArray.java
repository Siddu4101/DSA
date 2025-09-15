package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSumSubArray {

    /*
     * Q:https://leetcode.com/problems/maximum-subarray/description/
     * 53. Maximum Subarray
        Given an integer array nums, find the subarray with the largest sum, and return its sum.

        Example 1:
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: The subarray [4,-1,2,1] has the largest sum 6.

        Example 2:
        Input: nums = [1]
        Output: 1
        Explanation: The subarray [1] has the largest sum 1.

        Example 3:
        Input: nums = [5,4,-1,7,8]
        Output: 23
        Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     * */

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        log.info("the max sum of the subArray is {}", maxSubArray(nums));

    }

    private static int maxSubArray(int[] nums) {
        /*BrutForce approach*/
//        int maxSum = nums[0];
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum > maxSum)
//                    maxSum = sum;
//            }
//            sum = 0;
//        }

        /*o(n) sol*/
        int maxSum = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum < 0)
                sum = 0;
            sum += num;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
