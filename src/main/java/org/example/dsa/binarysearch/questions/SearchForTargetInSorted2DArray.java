package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchForTargetInSorted2DArray {
    /*
     * Q. given 2D sorted array find the target element
     * Ans. 1. take each row and then do a binary search for each row
     * Ans. 2. try to reduce the search space
     *       Approach: start the search from start of the row and end of the col
     *                    extreme = [0, len_of_col]
     *                   if(extreme == target)
     *                          return true;
     *                   else if(extreme < target)
     *                          row ++; //as we know it is sorted all the elements before/left to that will be smaller
     *                   else
     *                          col --; //as we know it is sorted all the elements below that element will be greater
     * */

    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}};
        int target = 38;
        log.info("is target {} present in the 2d array = {}", target, firstWaySearchIn2DSortedArrayByBinarySearch(arr, target));
        log.info("is target {} present in the 2d array = {}", target, secondWaySearchIn2DSortedArrayByBinarySearch(arr, target));
    }

    static boolean firstWaySearchIn2DSortedArrayByBinarySearch(int arr[][], int target) {
        for (int row = 0; row <= arr.length - 1; row++) {
            if (binarySearch(arr[row], target) != -1)
                return true;
        }
        return false;
    }

    static boolean secondWaySearchIn2DSortedArrayByBinarySearch(int arr[][], int target) {
        int row = 0;
        int col = arr.length - 1;
        while (col >= 0 && row <= arr.length - 1) {
            if (arr[row][col] == target)
                return true;
            else if (arr[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return arr[mid];
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
