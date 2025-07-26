package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindPeakInRotatedDuplicatedArray {
    public static void main(String[] args) {
        int[] arr = {2, 9, 2, 2};// {2, 2, 2, 2};
        log.info("Peak in rotated duplicate valued array {}", searchPeakInRotatedDuplicateValuedArray(arr));
    }

    private static int searchPeakInRotatedDuplicateValuedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            /*if peak is at extreme ends we need to compare the 1, 1 values to the neighbor*/
            boolean checkStart = (mid == 0 || arr[mid] >= arr[mid - 1]);
            boolean checkEnd = (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]);

            /*if both of the case satisfy then that is the peak*/
            if (checkEnd && checkStart)
                return arr[mid];
            else if (mid > 0 && arr[mid] > arr[mid + 1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
