package org.example.dsa.binarysearch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static org.example.dsa.binarysearch.BinarySearchBasicAlgo.searchForElementViaBinarySearchASC;
import static org.example.dsa.binarysearch.BinarySearchBasicAlgo.searchForElementViaBinarySearchDSC;

@Slf4j
public class OrderAgnosticBinarySearch {
    /*
     * In this kind(agnostic) of question we don't know the order of sort and need to find the element
     * Approach:
     * 1. pick start and end elements
     * 2. if start == end --> array has only 1 element check is it the target if yes you found the element else not
     * 3. if start > end  --> array is dsc sorted apply that search
     * 4. if start < end  --> array is asc sorted apply that search
     * */

    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 9, 24, 47, 78, 92};/*ASC*/
        int target = 24;
        log.info("searching for element {} in array(ASC) {} has a result {}", target, Arrays.toString(arr), orderAgnosticBinarySearch(arr, target));

        arr = new int[]{98, 74, 32, 21, 3, 1};/*DSC*/
        target = 21;
        log.info("searching for element {} in array(DSC) {} has a result {}", target, Arrays.toString(arr), orderAgnosticBinarySearch(arr, target));
    }

    private static boolean orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        if (arr[start] == arr[end])
            return arr[start] == target;
        else if (arr[start] < arr[end])
            return searchForElementViaBinarySearchASC(arr, target);
        else
            return searchForElementViaBinarySearchDSC(arr, target);
    }
}
