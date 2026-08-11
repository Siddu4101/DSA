package org.example.patternVice.slidingWindow;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;

@Slf4j
public class MaxSumOfDistinctSubArrayOfK {
    /*
     * Q:https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
     *2461. Maximum Sum of Distinct Subarrays With Length K
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
*
Example 2:
Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.
     *
     * */
    public static void main(String[] args) {
        int[] nums = {9, 18, 10, 13, 17, 9, 19, 2, 1, 18};
        int k = 5;
        log.info("The max distinct subarray sum is {}", maximumSubarraySumViaSet(nums, k));
        log.info("The max distinct subarray sum is {}", maximumSubarraySumViaFreMap(nums, k));
    }

    /*
     * Approach: 01
     * 1. create a hashMap for frequency count iterate over the array add the elements to sum and map till u reach first window(end - start + 1 == k)
     * 2. if map.len == k update the maxSum
     * 3. now remove the start element and reduce the count of it from the map if the count = 0 remove it from the map and move the start to find sum of next window
     * */

    public static long maximumSubarraySumViaFreMap(int[] nums, int k) {
        int start = 0;
        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        HashMap<Integer, Integer> freMap = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            freMap.put(nums[end], freMap.getOrDefault(nums[end], 0) + 1);/*increment the fre count*/
            sum += nums[end];

            if (end - start + 1 == k) { /*window reached*/
                if (freMap.size() == k) /*if window = freMap all r distinct so update maxSum*/
                    maxSum = Math.max(sum, maxSum);

                freMap.put(nums[start], freMap.get(nums[start]) - 1); /* now u need to remove the last element for next window*/
                sum -= nums[start];
                if (freMap.get(nums[start]) == 0)
                    freMap.remove(nums[start]);
                start++;
            }
        }
        return (maxSum == Long.MIN_VALUE) ? 0L : maxSum;
    }


    /*
     * Approach: 02
     * 1. if len < k return 0, i = 0, startOfWindow = 0 sum =0 , a set window for k+1  distinct elements(+1 bcz boundary extension and compression)
     * 2. iterate till len, if ith element present in set remove elements from window start and subtract that element from sum till the no duplicate for ith element and increment start window position
     *    now add the ith element to window and sum
     * 3. if element not present just add it to the window and sum
     * 4. if window has k elements update the maxSum
     * 5. else if window has k + 1 elements remove left most from window and sum and update the maxSum
     * */
    public static long maximumSubarraySumViaSet(int[] nums, int k) {
        int length = nums.length;

        if (length < k)
            return 0;

        HashSet<Integer> window = HashSet.newHashSet(k + 1);

        int i = 0;
        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        int startWindow = i;

        while (i < length) {
            if (window.contains(nums[i])) { /* element already present in the window*/
                while (window.contains(nums[i])) { /* remove element till no duplicate from the start of the window and decrement the sum update the start of the window*/
                    window.remove(nums[startWindow]);
                    sum -= nums[startWindow];
                    startWindow++;
                }
                sum += nums[i]; /*add the incoming element to the window and to the sum*/
                window.add(nums[i]);
            } else {
                window.add(nums[i]); /* if no duplicate just add to the window and sum*/
                sum += nums[i];
            }

            if (window.size() == k) { /* if window = k update the max */
                maxSum = Math.max(sum, maxSum);
            } else if (window.size() == k + 1) { /*if window = k + 1 remove left/ start of window element and subtract from sum and update start and update maxSum*/
                window.remove(nums[startWindow]);
                sum -= nums[startWindow];
                startWindow++;
                maxSum = Math.max(sum, maxSum);
            }
            i++; /* move to next element*/
        }
        return (maxSum == Long.MIN_VALUE) ? 0 : maxSum;
    }
}
