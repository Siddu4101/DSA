package org.example.neetcode75.arraysAndHashing.containsDuplicate2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;

@Slf4j
public class ContainsDuplicate {

/*
* Q: https://leetcode.com/problems/contains-duplicate/description/
*
217. Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
The element 1 occurs at the indices 0 and 3.
*
* */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        log.info("Via brut force: {}", containsDuplicateViaBrutForce(nums));
        log.info("Via sorted array: {}", containsDuplicateViaSort(nums));
        log.info("Via hashSet {}", containsDuplicateViaHashSet(nums));
    }

    /*Approach: 01
     * Time: O(n2)
     * Space: O(1)
     * */
    private static boolean containsDuplicateViaBrutForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    /*Approach: 02
     * Time: O(nlogn)
     * Space: O(1)
     * */
    private static boolean containsDuplicateViaSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    /*Approach:03
     * Time: O(n)
     * Space: O(n)
     * */
    private static boolean containsDuplicateViaHashSet(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            if (numsSet.contains(num))
                return true;
            numsSet.add(num);

            /*u can replace contain and add 2 diff operation to single by
             * if(!numSet.add(num))
             *   return true;
             * */
        }
        return false;
    }


}
