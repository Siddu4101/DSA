package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class DoesRotationOfMatrixMatchesWithTarget {
    /*
     * Q: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
     * 1886. Determine Whether Matrix Can Be Obtained By Rotation
        Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
        Example 1:
        Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
        Output: true
        Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

        Example 2:
        Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
        Output: false
        Explanation: It is impossible to make mat equal to target by rotating mat.

        Example 3:
        Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
        Output: true
        Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
     * */


    public static void main(String[] args) {
        int[][] mat = {{0, 1}, {1, 0}};
        int[][] target = {{1, 0}, {0, 1}};
        log.info("is matrix rotation matches with target {}", findRotation(mat, target));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        /*check if the number of 1's and 0s are matching*/
        int numberOfRows = mat.length;
        int numberOfCols = mat[0].length;
        int numOnesInMat = 0;
        int numZerosInMat = 0;
        int numOnesInTarget = 0;
        int numZerosInTarget = 0;

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                if (mat[i][j] == 1)
                    numOnesInMat++;
                else
                    numZerosInMat++;

                if (target[i][j] == 1)
                    numOnesInTarget++;
                else
                    numZerosInTarget++;

            }
        }
        log.info("number of ones and zeros in mat {} {}", numOnesInMat, numZerosInMat);
        log.info("number of ones and zeros in target {} {}", numOnesInTarget, numZerosInTarget);
        if ((numOnesInTarget != numOnesInMat) || (numZerosInMat != numZerosInTarget))
            return false;

        /*rotate 4 times if any of them match return true*/
        for (int i = 0; i < 4; i++) {
            rotateBy90(mat);
            reverseRows(mat);
            if (compareResults(mat, target))
                return true;
        }
        return false;
    }

    private static boolean compareResults(int[][] mat, int[][] target) {
        int length = mat.length;
        /*compare the result*/
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        log.info("results are matching");
        return true;
    }

    private static void rotateBy90(int[][] mat) {
        int length = mat.length;
        /*transpose of array*/
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        log.info("transpose {}", Arrays.deepToString(mat));
    }

    private static void reverseRows(int[][] mat) {
        /*reverse the row elements*/
        int length = mat.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0, k = length - 1; j < k; j++, k--) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
            }
        }
        log.info("the reverse of rows creates rotated array {} ", Arrays.deepToString(mat));
    }
}