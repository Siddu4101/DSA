package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MountainPeakElement {
    /*
     * 162. Find Peak Element
     * Example 1:

     *   Input: nums = [1,2,3,1]
     *   Output: 2
     *   Explanation: 3 is a peak element and your function should return the index number 2.
     *   Example 2:
     *
     *   Input: nums = [1,2,1,3,5,6,4]
     *   Output: 5
     *   Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
     * */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        log.info("output:{}", getThePeakElementInAMountainArray(nums));
    }

    static int getThePeakElementInAMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start != end) {
            mid = start + (end - start) / 2; /*to avoid the int range exceed if we use (start + end) / 2*/
            if (nums[mid] < nums[mid + 1])
                start = mid + 1;
            else if (nums[mid] > nums[mid + 1])
                end = mid;
        }
        return start;
    }
}
