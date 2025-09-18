package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class FindUniqueNumbersInSortedArrayInAGivenOrder {
    /*
     * Q:https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
     *26. Remove Duplicates from Sorted Array
        Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
        Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
        Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
        Return k.
        Custom Judge:
        The judge will test your solution with the following code:

        int[] nums = [...]; // Input array
        int[] expectedNums = [...]; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        If all assertions pass, then your solution will be accepted.

        Example 1:
        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).

        Example 2:
        Input: nums = [0,0,1,1,1,2,2,3,3,4]
        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
     * */
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        log.info("The number of unique elements in array {}", removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {

        /*Approach 1 via Map*/
//        Map<Integer, Integer> unique = new HashMap<>();
//        int index1 = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (unique.put(nums[i], 0) == null)
//                nums[index1++] = nums[i];
//        }
//        log.info("The array after removal of the duplicates {} ", nums);
//        return  index1;

        Set<Integer> uniqueSet = new HashSet<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (uniqueSet.add(nums[i]))
                nums[index++] = nums[i];
        }
        log.info("The array after removal of the duplicates {} ", nums);
        return index;
    }
}

