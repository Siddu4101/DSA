package org.example.dsa.linearsearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchIn2DArray {

    /*
     * given a target along with a 2D array try to find that element in this array
     * [
     *  [1,2,3]
     *  [4,5,6]
     * ]
     * target = 5
     * result = true
     * */
    public static void main(String[] args) {
        int[][] arr2D = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int target = 5;
        log.info("searching for element {} in array got result {}", target, searchIn2DArray(arr2D, target));
    }

    private static boolean searchIn2DArray(int[][] arr2D, int target) {
        if (arr2D.length == 0)
            return false;

        for (int[] arr : arr2D) {
            for (int val : arr) {
                if (val == target)
                    return true;
            }
        }
        return false;
    }
}
