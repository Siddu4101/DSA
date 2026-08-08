package org.example.patternVice.slidingWindow;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MaxSumOfSubArrayWithKElements {
    /*
     * Q: https://www.hellointerview.com/learn/code/sliding-window/maximum-sum-of-subarrays-of-size-k
     *DESCRIPTION
Given an array of integers nums and an integer k, find the maximum sum of any contiguous subarray of size k.
Example 1: Input:
nums = [2, 1, 5, 1, 3, 2]
k = 3
Output = 9 ==> [5,1,3]
     *
     * */

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 6};
        int k = 4;
        log.info("The max sub array of {} elements in sequence is {}", k, maxSubArraySum(nums, k));
        log.info("The max sub array of {} elements in sequence is {}", k, maxSubArraySumOptimized(nums, k));
    }

    /*
     *Approach: 01
     * 1. iterator over array if elements < k return
     * 2. set the sum of the subArray = 0, and keep k in size of subarray and iterator of the subarray iterator ver subarray and compute the sum
     * 3. if subarray sum > maxSum replace it
     * */

    /*
     * T: O(n*k)
     * S: O(1)
     * */
    private static int maxSubArraySum(int[] nums, int k) {
        int sumOfSubArray;
        int maxSum = Integer.MIN_VALUE;
        int subArrayIterator;
        int subArraySize;

        if (nums.length < k)
            return maxSum;


        for (int l = 0; l < nums.length - k + 1; l++) {
            subArrayIterator = l;
            subArraySize = k;
            sumOfSubArray = 0;
            while (subArraySize > 0) {
                sumOfSubArray += nums[subArrayIterator++];
                subArraySize--;
            }
            maxSum = Math.max(sumOfSubArray, maxSum);
        }
        return maxSum;
    }

    /*
     * Approach: 02
     * Note: in above example we are moving only by 1 (l++) but recomputing the sum for the subarray which is unnecessary
     * we just need to subtract the element we moved from and add the element we moved to for better time complexity
     * 1. find the sum of k subarray at once in the starting
     * 2. from i = 1 to till len - k + 1 subtract the one being discarded from the window and add the one being added to the window
     * 3. check if the new sum > maxSum if yes replace it
     * */

    /*
     * T: O(n)
     * S: O(1)
     * */
    private static int maxSubArraySumOptimized(int[] nums, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        if (nums.length < k)
            return maxSum;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        maxSum = sum;

        for (int i = 1; i < nums.length - k + 1; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

}
