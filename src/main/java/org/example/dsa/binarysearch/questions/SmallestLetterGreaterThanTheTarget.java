package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class SmallestLetterGreaterThanTheTarget {

    /*
     * 744. Find Smallest Letter Greater Than Target
     * Input: letters = ["c","f","j"], target = "a"
     * Output: "c"
     *
     * target = "c"
     * Output: "f" --> next greater element of c is f
     *
     * target = k
     * Output: "c" -->  There are no characters in letters that is lexicographically greater than 'h' so we return letters[0].
     *
     * */
    public static void main(String[] args) {
        char[] chars = {'c', 'f', 'j'};
        char target = 'd';
        log.info("smallest greater element than the target is {} in the given array {}", getSmallestGreaterElementThanTarget(chars, target), Arrays.toString(chars));
    }

    private static char getSmallestGreaterElementThanTarget(char[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        char nearestMax = arr[0];
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
            if (arr[mid] > target)
                nearestMax = arr[mid];
        }
        return nearestMax;
    }
}
