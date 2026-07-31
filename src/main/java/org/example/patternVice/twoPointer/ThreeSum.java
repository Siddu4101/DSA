package org.example.patternVice.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ThreeSum {

    /*
    *
    * Q:https://leetcode.com/problems/3sum/description/
    * 15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
    * */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        log.info("The pairs are {}", threeSum(nums));
    }


    /*
     * Approach:
     * 0. sort the array
     * 1. keep a iterator to iterate over all the elements till len -2  bcz we need 3 elements to make sum = 0
     * 2. for given iterator i find the possible j and k which makes sum  = 0 and keep only one pair if duplicate using set
     * 3. note: while finding the triplet if sum = 0 u can move either jto right or k to left no issues
     * */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int j, k, sum;

        for (int i = 0; i < nums.length - 2; i++) {
            Arrays.sort(nums);
            j = i + 1;
            k = nums.length - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
                else {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }
        return res.stream().toList();
    }
}
