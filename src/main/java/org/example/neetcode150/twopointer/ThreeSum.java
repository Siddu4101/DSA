package org.example.neetcode150.twopointer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ThreeSum {

    /*Q: https://leetcode.com/problems/3sum/description/
     *15. 3Sum
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
     * */

    /*
     * Notice that the solution set must not contain duplicate triplets.
     * Notice that the order of the output and the order of the triplets does not matter.
     * */

    public static void main(String[] args) {
        int[] nums = {0, 1, 1};//{-1, 0, 1, 2, -1, -4};
        log.info("The triplets possible is {}", threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        /*Sort the array*/
        Arrays.sort(nums);

        /*while end of the array or till we reach +ve number as if we have any number >0 then sum can't be 0 for next 3 number triplet*/
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) { /* -2 bcz min we need 3 elements the is possible at < index - 2*/

            /*set the 2 pointers*/
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {/*for each j to k search path for the ith element negation i + j + k = 0 ==> -i = j + k */
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) { /*if sum is 0 add to result*/
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) /* to search next entry in the right search space*/
                        j++;
                    j++; /*to avoid the duplicate entry*/
                } else if (sum < 0) { /*if sum is < then increment the j until no duplicates*/
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    j++;
                } else {/*if sum is > then  decrement the k until no duplicates*/
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    k--;
                }
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1])/* for next non-duplicate element -3 bcz another ++ happens in the for loop so we still meet the min 3 elements for the sum*/
                i++;
        }
        return res;
    }

}
