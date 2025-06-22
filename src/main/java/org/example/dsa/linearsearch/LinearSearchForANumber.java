package org.example.dsa.linearsearch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static org.example.dsa.linearsearch.util.SearchUtils.linearSearch;

@Slf4j
public class LinearSearchForANumber {
    public static void main(String[] args) {
        /*Linear search
         * searches for a target element in whole array element by element
         * Time complexity
         * o(1) --> when the target element is at the 0th index of a array
         * o(n) --> when the target element is at the last index of a array
         * */

        int[] arr = {1, 3, 6, 34, 66, 42, 7, 88, 25};
        int target = 3;
        log.info("is element {} present in the array {} = {}", target, Arrays.toString(arr), linearSearch(arr, target));
    }

}
