package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class CeilingAndFloorOfArray {
    /*
     * Q. given a ASC ordered array find the ceiling(nearest >= target)
     * Ex. [2,3,5,9,14,16,18]
     * if target = 14 --> result = 14
     * if target = 15 --> result = 16
     * */

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 12;
        log.info("ceiling in array {} for given number {} is {} ", Arrays.toString(arr), target, getCeilingWithBs(arr, target));
        log.info("floor in array {} for given number {} is {} ", Arrays.toString(arr), target, getFloorWithBs(arr, target));
    }

    private static int getCeilingWithBs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int nearestMax = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                nearestMax = arr[mid];
                return nearestMax;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
            if (arr[mid] >= target)
                nearestMax = arr[mid];
        }
        return nearestMax;
    }


    private static int getFloorWithBs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int nearestMin = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                nearestMin = arr[mid];
                return nearestMin;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;

            if (arr[mid] <= target)
                nearestMin = arr[mid];
        }
        return nearestMin;
    }

    /*Another way*/
    /*
     * remove the extra var nearest*** and use below ones
     * Ceiling
     * Just return the start after violating the s > e condition and handle that
     * if target > arr[arr.length -1] -->  return -1
     *
     *
     * Floor
     * Just return the end of after violating the s > e condition and handle that
     * if target < arr[0] --> return -1
     * */
}
