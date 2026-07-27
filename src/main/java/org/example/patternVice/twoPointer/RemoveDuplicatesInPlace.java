package org.example.patternVice.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class RemoveDuplicatesInPlace {
    /*
     * Q:https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
     *26. Remove Duplicates from Sorted Array
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
Consider the number of unique elements in nums to be k, After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

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

* Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

* Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
     * */
    public static void main(String[] args) {
        int nums[] =
                {1, 1, 2};
        //                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        log.info("The k value is {} via Two Pointers", removeDuplicatesInPlaceTwoPointer(nums));
        log.info("The k value is {} via HashSet", removeDuplicatesInPlaceViaSet(nums));
    }

    /*
     * Approach:
     * - `start` points to the last unique element placed in the array.
     * - `next` scans forward to find the next new value.
     * - When a new value is found, place it at `start + 1` and move `start`.
     * */

    /*
     * T: O(n): one pass
     * S: O(1)
     * */
    private static int removeDuplicatesInPlaceTwoPointer(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int start = 0;
        int next = 1;

        while (next < nums.length) {
            if (nums[next] != nums[start]) {
                start++;
                nums[start] = nums[next];
            }
            next++;
        }

        log.info("Elements after shift {} via two pointer", Arrays.toString(nums));
        return start + 1;
    }


    /*EXTRA*/

    /*
     * Approach : 02
     * via set
     * 1. start from 0th index as unique index id
     * 2. add elements to the set if it added it means it's unique one
     * 3. update the element in the unique index position
     * 4. return the unique index as a k count
     * */
    static int removeDuplicatesInPlaceViaSet(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        int unique = 0;
        for (int i = 0; i < nums.length; i++) {
            if (integers.add(nums[i]))
                nums[unique++] = nums[i];
        }
        log.info("Elements after shift {} via hashset", Arrays.toString(nums));
        return unique;
    }
}
