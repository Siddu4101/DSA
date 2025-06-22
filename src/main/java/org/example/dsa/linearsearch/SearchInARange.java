package org.example.dsa.linearsearch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static org.example.dsa.linearsearch.util.SearchUtils.linearSearch;

@Slf4j
public class SearchInARange {

    /*Q.search for a target number in a given array in a given array index range
     * Ex:
     * arr = [1,3,6,56,73,-34,45]
     * target = 73
     * range = 0-4
     * result = true
     *
     * target 6
     * range = 4-6
     * result = false
     * */

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 56, 73, -34, 45};
        /*case: 01*/
        int target = 73;
        int minRange = 0;
        int maxRange = 4;
        log.info("is searching element {} present in array {} index {} - {} = {}", target, Arrays.toString(arr), minRange, maxRange, linearSearchInRange(arr, target, minRange, maxRange));

        /*Case: 02*/
        target = 6;
        minRange = 4;
        maxRange = 6;
        log.info("is searching element {} present in array {} index {} - {} = {}", target, Arrays.toString(arr), minRange, maxRange, linearSearchInRange(arr, target, minRange, maxRange));
    }

    static boolean linearSearchInRange(int[] arr, int target, int minRange, int maxRange) {
        int length = maxRange - minRange + 1;
        int[] newArr = new int[length];

        for (int i = 0; i < length; i++) {
            newArr[i] = arr[minRange];
            minRange++;
        }
        log.info("sub array {}", Arrays.toString(newArr));
        return linearSearch(newArr, target);
    }
}
