package org.example.patternVice.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class SortColors {
    /*
     * Q: https://leetcode.com/problems/sort-colors/
     *75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
     *
     * */

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        log.info("The sorted colors array is");
        sortColors(nums.clone());
        log.info("The sorted colors with 2 pointer");
        sortColorWithPointers(nums);
    }

    /*
     *Approach:01
     * 1. count the number of 0, 1
     * 2. insert number of 0 and 1 count numbers in the same array and rest with 2
     * */

    /*
     * T: O(n)
     * S: O(1)
     * */

    public static void sortColors(int[] nums) {
        int zc = 0, oc = 0;
        for (int i : nums) {
            if (i == 0)
                zc++;
            else if (i == 1)
                oc++;
        }

        int i = 0;
        while (zc > 0) {
            nums[i++] = 0;
            zc--;
        }
        while (oc > 0) {
            nums[i++] = 1;
            oc--;
        }
        while (i < nums.length)
            nums[i++] = 2;

        System.out.println(Arrays.toString(nums));
    }

    /*
     * Approach: 02
     * 1. similar to move zeros questin use the same login call twice to shift the zero's and then one's for 2 no need as it does
     *    automatically doe as we have only 3 numbers
     * */

    /*
     * T: O(n)
     * S: O(1)
     * */
    public static void sortColorWithPointers(int[] nums) {
        int nextOneIndex = moveNumbers(nums, 0, 0);
        moveNumbers(nums, nextOneIndex, 1);
        System.out.println(Arrays.toString(nums));
    }

    private static int moveNumbers(int[] nums, int nextIndex, int color) {
        for (int i = nextIndex; i < nums.length; i++) {
            if (nums[i] == color) {
                int temp = nums[nextIndex];
                nums[nextIndex] = color;
                nums[i] = temp;
                nextIndex++;
            }
        }
        return nextIndex;
    }
}
