package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class SpiralMatrix {

    /*
    * Q:https://leetcode.com/problems/spiral-matrix/description/
    * 54. Spiral Matrix
        Given an m x n matrix, return all elements of the matrix in spiral order.

        Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,3,6,9,8,7,4,5]

        Example 2:
        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]

        Example 3:
        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16],[17,18,19,20],[21,22,23,24]]
        Output: [1,2,3,4,8,12,16,20,24,23,22,21,17,13,9,5,6,7,11,15,19,18,14,10]
        */

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        log.info("printing spiral traversed matrix {}", printSpiralMatrix(matrix));
    }

    /*=================Second approach completely working=================================*/
    private static List<Integer> printSpiralMatrix(int[][] matrix) {
        /*to get the row and col count*/
        int rc = matrix.length;
        int cc = matrix[0].length;
        int totalElements = rc * cc;
        /*to maintain the boundary from start and end row and col after each layer*/
        int rs = 0;
        int cs = 0;
        int re = rc;
        int ce = cc;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.ceilDiv(rc, 2); i++) {
            int ri = rs;
            int ci = cs;

            /*to get the left to right row*/
            while (ci < ce && checkResultSize(result, totalElements)) {
                result.add(matrix[ri][ci++]);
            }
            ci--;/*to keep the pointer on the last col*/
            ri++;/*to move to the next row*/

            /*to get the top to bottom col*/
            while (ri < re && checkResultSize(result, totalElements)) {
                result.add(matrix[ri++][ci]);
            }
            ri--;
            ci--;

            /*to get the right to left row*/
            while (ci >= cs && checkResultSize(result, totalElements)) {
                result.add(matrix[ri][ci--]);
            }
            ci++;
            ri--;

            /*to get the bottom to top col*/
            while (ri > rs && checkResultSize(result, totalElements)) {
                result.add(matrix[ri--][ci]);
            }

            /*to shrink the row and col boundary by one layer*/
            rs += 1;
            cs += 1;
            re -= 1;
            ce -= 1;
        }
        return result;
    }

    private static boolean checkResultSize(List<Integer> result, int totalElements) {
        return result.size() < totalElements;
    }


    /*==========================First approach which has some issue so refer the above approach which is better one========================*/
    private static List<Integer> spiralOrder(int[][] matrix) {
        /*for r row array we need to perform r-1 times revert and shuffle*/
        for (int i = 0; i < matrix.length - 1; i++)
            reverseAndShuffle(matrix, i + 1);/*to start the reversing and shuffling from 2nd row as first row remain intact*/

        /*flattening the response to make 1D array*/
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).boxed().toList();
    }

    private static void reverseAndShuffle(int[][] matrix, int startRow) {
        /*reverse rows*/
        for (int i = startRow; i < matrix.length; i++) {
            for (int j = 0, k = matrix[i].length - 1; j < k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }

        log.info("After reversing the rows from startRow {} is", startRow);
        print2DArray(matrix);

        /*shuffle the elements in a X(pattern) way between 2 rows starting from 2nd row*/
        for (int i = startRow; i + 1 < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i + 1][j - 1];
                matrix[i + 1][j - 1] = temp;
            }
        }

        log.info("Matrix after row revert and shuffle ");
        print2DArray(matrix);
    }

    private static void print2DArray(int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.print("[");
            for (int a : arr) {
                System.out.print(a + ", ");
            }
            System.out.print("]\n");
        }
    }

}
