package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunningSum {
    /*
     *https://leetcode.com/problems/running-sum-of-1d-array/
     *Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
      Return the running sum of nums.
        Example 1:
        Input: nums = [1,2,3,4]
        Output: [1,3,6,10]
        Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

        Example 2:
        Input: nums = [1,1,1,1,1]
        Output: [1,2,3,4,5]
        Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
     * */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        log.info("Running Sum array of given array is {}", getRunningSum(nums));
    }

    private static int[] getRunningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        return nums;
    }
}
