package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class RotateAn2DMatrix {

    /*
     * Q:https://leetcode.com/problems/rotate-image/description/
     *48. Rotate Image
        You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
        Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[7,4,1],[8,5,2],[9,6,3]]
        *
        Approach:
        1. To rotate n x n array by 90 clockwise
            a. transpose the array first(row as col and col as row)
            b. reverse the each row

        2. To rotate n x n array by 90 anticlockwise
            a. transpose the array first
            b. reverse the each column

        3. To rotate n x n matrix by 180(clock or anticlockwise)
            a. reverse the each row
            b. reverse the each column
     * */
    public static void main(String[] args) {
        clockWise90Rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        antiClockWise90Rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        rotate180(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static void clockWise90Rotate(int[][] matrix) {
        int length = matrix.length;
        transpose(matrix, length);
        log.info("transposed matrix {}", Arrays.deepToString(matrix));

        /*Reverse rows*/
        for (int i = 0; i < length; i++) {
            for (int j = 0, k = length - 1; j <= k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
        log.info("The clock wise 90 rotated matrix look like {}", Arrays.deepToString(matrix));
    }

    public static void antiClockWise90Rotate(int[][] matrix) {
        int length = matrix.length;
        transpose(matrix, length);
        log.info("transposed matrix {}", Arrays.deepToString(matrix));

        /*Reverse col*/
        for (int i = 0; i < length; i++) {
            for (int j = 0, k = length - 1; j < k; j++, k--) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
        log.info("The anticlockwise 90 rotated matrix look like {}", Arrays.deepToString(matrix));
    }


    public static void rotate180(int[][] matrix) {
        int length = matrix.length;
        /*Reverse rows*/
        for (int i = 0; i < length; i++) {
            for (int j = 0, k = length - 1; j <= k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }

        /*Reverse col*/
        for (int i = 0; i < length; i++) {
            for (int j = 0, k = length - 1; j < k; j++, k--) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
        log.info("The 180 rotated matrix look like {}", Arrays.deepToString(matrix));
    }

    /*Transpose a matrix*/
    public static void transpose(int[][] matrix, int length) {
        /*transpose*/
        /*for in place transpose use the inner loop j = i+1 (to avoid double swap which cancel out the actual swap)*/
        /*else better use new matrix and do a simple 2 loop run and place transpose[j][i] = matrix[i][j]*/
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
