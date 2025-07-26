package org.example.dsa.binarysearch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class BinarySearchBasicAlgo {

    /*
     * Binary Search
     * this algorithm only applicable if the array is sorted either in asc or desc
     * time complexity is log2(n)
     * basically divide the array into half on every next step and search for the element
     * 1. start = 0, end = last index; (start + end)/2 --> mid-element
     * 2. if mid > target --> search in the left half of the array; start = start and end = mid - 1
     * 3. if mid < target --> search in the right half of the array; start = mid + 1 and end = end
     * 4. if mid == target --> you found your target
     * 5. if stat > end --> element is not present in the array
     *
     * Note:
     * to calculate mid we have
     *  mid = (start + end) / 2 --> but here if we have the start and end as big numbers which exceed the
     *                              int range may get the error so use it like
     *  mid = start + (end - start) / 2 --> this also gives the same result in the end --> (2s + e - s) / 2 --> (s + e) / 2
     * */
    public static void main(String[] args) {
        /*ASC array search*/
        int[] arr = {3, 4, 6, 9, 24, 47, 78, 92};
        int target = 92;
        log.info("searching for element {} in array {} has a result {}", target, Arrays.toString(arr), searchForElementViaBinarySearchASC(arr, target));

        /*DSC array search*/
        arr = new int[]{98, 74, 32, 21, 3, 1};
        target = 1;
        log.info("searching for element {} in array {} has a result {}", target, Arrays.toString(arr), searchForElementViaBinarySearchDSC(arr, target));
    }

    static boolean searchForElementViaBinarySearchASC(int[] arr, int target) {
        if (arr.length == 0)
            return false;

        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2; /*to avoid the int range exceed if we use (start + end) / 2*/
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }


    static boolean searchForElementViaBinarySearchDSC(int[] arr, int target) {
        if (arr.length == 0)
            return false;

        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2; /*to avoid the int range exceed if we use (start + end) / 2*/
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}

class Test {
    public static int findPeak(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean isLeftSmaller = (mid == 0 || nums[mid] >= nums[mid - 1]);
            boolean isRightSmaller = (mid == nums.length - 1 || nums[mid] >= nums[mid + 1]);

            if (isLeftSmaller && isRightSmaller) {
                return nums[mid]; // Found peak
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // fallback (shouldn't reach here if array has at least one peak)
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 2, 2, 2};
        System.out.println("Peak: " + findPeak(nums)); // Output: 9
    }
}