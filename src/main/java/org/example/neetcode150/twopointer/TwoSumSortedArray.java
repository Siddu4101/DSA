package org.example.neetcode150.twopointer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoSumSortedArray {

    /*
     * Q:https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     *167. Two Sum II - Input Array Is Sorted
        Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
        Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
        Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.
        The tests are generated such that there is exactly one solution. You may not use the same element twice.
        Your solution must use only constant extra space.
        Example 1:
        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     * */
    /*Expected a constant space*/

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4};//{2, 7, 11, 15};
        int target = 6;
        log.info("The index for the Two Sum is {} via TwoPointer", twoSumViaTwoPointer(numbers, target));
        log.info("The index for the Two Sum is {} via BinarySearch", twoSumViaBinarySearch(numbers, target));
    }

    /*Approach: 01 Tow Pointer: here as the array is already sorted we will use the two pointer
     * 1. use i=0 and j=n-1 while i<j try to find the pair as i must < j as per question
     * 2. if any matches found for some of i and j return the array with 1 addition for both pointer as array is 1 indexed
     * 3. if sum < target increment i
     * 4. if sum > target decrement the j
     * */
    public static int[] twoSumViaTwoPointer(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target)/*it matches the target return the array of i+1 and j+1 (as index starts from 1)*/
                return new int[]{i + 1, j + 1};
            else if (sum < target)/*If target is greater increment i*/
                i++;
            else /*if target is lesser decrement j*/
                j--;
        }
        return new int[]{-1, -1};
    }
    /*
     * TIME: O(n) -- traversed the whole array
     * SPACE: O(1) -- constant space as no extra space used
     * */

    /*Approach:02 Binary search
     * 1. take the each element in a for loop and then cal the diff
     *    diff = target - element; now u need to find the diff in the array via binary search
     * 2. continue this toll end of the array to find the result
     * */
    public static int[] twoSumViaBinarySearch(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            int l = i + 1; /*as we know we need to search the next element which is > i */
            int r = numbers.length - 1;

            /*Binary Search*/
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == diff)/*it matches the target return the array of l+1 and r+1 (as index starts from 1)*/
                    return new int[]{i + 1, mid + 1};
                else if (numbers[mid] < target)/*If target is greater increment l reduce the search space from the left side*/
                    l++;
                else /*if target is lesser decrement r reduce the search space from right side*/
                    r--;
            }

        }
        return new int[]{-1, -1};
    }
    /*
     * TIME: O(nlog(n))
     * SPACE: O(1)
     * */
}