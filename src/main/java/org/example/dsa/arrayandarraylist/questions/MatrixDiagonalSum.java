package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MatrixDiagonalSum {
    /*
     * Q:https://leetcode.com/problems/matrix-diagonal-sum/
     *1572. Matrix Diagonal Sum
        Given a square matrix mat, return the sum of the matrix diagonals.
        Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
        Example 1:
        Input: mat = [[1,2,3],
                      [4,5,6],
                      [7,8,9]]
        Output: 25
        Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
        Notice that element mat[1][1] = 5 is counted only once.
        Example 2:
        Input: mat = [[1,1,1,1],
                      [1,1,1,1],
                      [1,1,1,1],
                      [1,1,1,1]]
        Output: 8
        Example 3:

        Input: mat = [[5]]
        Output: 5
     *
     * */
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        log.info("sum of primary and secondary diagonal is {}", diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        /*
         * Approach
         * a. primary diagonal elements identification
         *    the position of the r[i],c[i] in primary diagonal will be equal r[i] == c[i]
         * b. secondary diagonal elements identification
         *    the sum of the r[i] + c[i] = n - 1
         * c. now sum both results
         * NOTE : if u use the else if in the secondarySum then we don't need the step d as it is not adding the middle element to secondary sum
         * d. if the n % 2 != 0 then we need to remove the common sum element
         *    to identify the middle/common element position do the n/2 then subtract the r[i]c[i] in the final result
         *
         * */
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        int length = mat.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j)
                    primaryDiagonalSum += mat[i][i];
                else if (i + j == length - 1)
                    secondaryDiagonalSum += mat[i][j];
            }
        }
        return primaryDiagonalSum + secondaryDiagonalSum;
    }
}
