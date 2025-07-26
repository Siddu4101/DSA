package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindTargetInRotatedSortedArray {
    /*
     * Rotated Array
     * It is an array which will have the 2 asc part and 1 pivot element
     * pivot element --> largest element in the rotated array
     * [4,5,6,7,0,1,2] --> pivot = 7 and till pivot from start it's asc and from after pivot to end is another asc
     * but at pivot we have 2 cases like
     * i. mid > mid + 1 element when pivot = mid
     * ii. mid -1 < mid element when mid = pivot + 1 element
     *
     * */

    /*
     *
     * 33. Search in Rotated Sorted Array
     * Example 1:

     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     * */

    /*
     * Solution Approach:
     * 1. find the peak element index that is pivot
     * 2. if pivot not found it is not a rotated array so do a norma binary search
     * 3. if pivot == target --> ans
     * 4. else try to find the target element from 0-peakElementIndex(in Asc array)
     * 5. if not found search element in the peakElementIndex-end (in Asc array)
     * */
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};// {5, 1, 3};//
        int target = 6;
        log.info("OutPut:{}", search(arr, target));
    }

    public static int search(int[] nums, int target) {
        /*Find the peak*/
        int peakElementIndex = peakElementInRotatedArray(nums);

        /*if not a rotated array do a binary search*/
        if (peakElementIndex == -1) {
            return searchInAscArray(nums, 0, nums.length - 1, target);
        } else {
            /*check is pivot == target*/
            if (nums[peakElementIndex] == target)
                return peakElementIndex;
            else if (nums[0] <= target)/*if start >= pivot search till pivot element*/
                return searchInAscArray(nums, 0, peakElementIndex, target);
            else /*else search from pivotElement + 1 to end */
                return searchInAscArray(nums, peakElementIndex + 1, nums.length - 1, target);
        }
    }

    static int peakElementInRotatedArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            /*when pivot = mid*/
            if (mid != nums.length - 1 && nums[mid] > nums[mid + 1])
                return mid;
                /*when pivot + 1 = mid*/
            else if (mid != 0 && nums[mid] < nums[mid - 1])
                end = mid - 1;

                /*when start > mid this is rotated array so that if start > mid the answer lies in the left subarray so end = mid -1*/
            else if (nums[start] > nums[mid])
                end = mid - 1;
                /*when start < mid this is rotated array so that if start < mid the answer lie on the right half so start = mid + 1*/
            else
                start = mid + 1;
        }
        /*if we don't find any pivot element then it is not a rotated array*/
        return -1;
    }

    static int searchInAscArray(int[] nums, int startIndex, int peakElementIndex, int target) {
        int start = startIndex;
        int end = peakElementIndex;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}