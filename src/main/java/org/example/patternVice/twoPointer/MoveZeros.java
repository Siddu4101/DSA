package org.example.patternVice.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MoveZeros {


    /*
     * Q: https://leetcode.com/problems/move-zeroes/description/
     *
283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]     * */

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};//{2, 1};//, 0, 3, 12};
        moveZerosSimpleTwoPointerApproach1(nums.clone());
        moveZeroesViaTwoPointerApproach2(nums.clone());
    }


    /*
     * Approach: 01
     * 1. keep 2 pointer both start at 0,  iterator -> which goes through all the elements nextNonZeroElementIndex -> where we place net non-zero element
     * 2. move the iterator if the value of iterator is not 0 then swap it with nextNonZeroElementIndex and increment the index for the next val
     * 3. if the iterator value is 0 just move the iterator to next val
     * */
    static void moveZerosSimpleTwoPointerApproach1(int[] nums) {
        int nextNonZeoElementIndex = 0;
        for (int iterator = 0; iterator < nums.length; iterator++) {
            if (nums[iterator] != 0) {
                int temp = nums[nextNonZeoElementIndex];
                nums[nextNonZeoElementIndex] = nums[iterator];
                nums[iterator] = temp;
                nextNonZeoElementIndex++;
            }
        }
        log.info("After moving 0's to the end {}", Arrays.toString(nums));
    }


    /*
     * Approach: 02 not much better one
     *   1. keep zeroIndex pointer at first 0 element and the nonZeroIndex pointer to first non-zeo element and also zeroIndex  < nonZeroIndex
     *   2. swap the elements continue from that point
     *   3. repeat 1 and 2 till zero/nonZero index reaches len
     * */

    /*
     * T: O(n)
     * S: O(1)
     * */
    public static void moveZeroesViaTwoPointerApproach2(int[] nums) {
        if (nums.length <= 1)
            return;
        int zeroIndex = 0;
        int nonZeroIndex = 1;
        while (nonZeroIndex < nums.length) {
            while (zeroIndex < nums.length && nums[zeroIndex] != 0)
                zeroIndex++;

            while (nonZeroIndex < nums.length && (nums[nonZeroIndex] == 0 || zeroIndex > nonZeroIndex))
                nonZeroIndex++;

            if (zeroIndex >= nums.length - 1 || nonZeroIndex >= nums.length) {
                log.info("After moving 0's to the end {}", Arrays.toString(nums));
                return;
            }

            if (nums[nonZeroIndex] != 0) {
                nums[zeroIndex] = nums[nonZeroIndex];
                nums[nonZeroIndex] = 0;
                nonZeroIndex++;
            }
        }
        log.info("After moving 0's to the end {}", Arrays.toString(nums));
    }
}
