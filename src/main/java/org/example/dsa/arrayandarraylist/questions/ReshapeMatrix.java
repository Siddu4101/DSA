package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ReshapeMatrix {

    /*
     * Q: https://leetcode.com/problems/reshape-the-matrix/description/
     *566. Reshape the Matrix
        In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
        You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
        The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
        If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

        Example 1:
        Input: mat = [[1,2],[3,4]], r = 1, c = 4
        Output: [[1,2,3,4]]

        Example 2:
        Input: mat = [[1,2],[3,4]], r = 2, c = 4
        Output: [[1,2],[3,4]]
     * */

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 2;
        int c = 4;
        log.info("The res is {}", Arrays.deepToString(matrixReshape(mat, r, c)));
    }

    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[] flattenedArray = Arrays.stream(mat).flatMapToInt(Arrays::stream).toArray();
        int seq = 0;
        if (r * c != flattenedArray.length)
            return mat;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = flattenedArray[seq++];
            }
        }
        return res;
    }
}
