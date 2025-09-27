package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class SpiralMatrixGeneration {

    /*
     * Q:https://leetcode.com/problems/spiral-matrix-ii/description/
     *59. Spiral Matrix II
        Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

        Example 1:
        Input: n = 3
        Output: [[1,2,3],[8,9,4],[7,6,5]]

        Example 2:
        Input: n = 1
        Output: [[1]]
     * */


    public static void main(String[] args) {
        int n = 3;
        log.info("spiral matrix {}", Arrays.deepToString(generateMatrix(n)));
    }

    private static int[][] generateMatrix(int n) {
        /*to get the row and col count*/
        int totalElements = n * n;
        int itemInserted = 0;
        /*to maintain the boundary from start and end row and col after each layer*/
        int rs = 0;
        int cs = 0;
        int re = n;
        int ce = n;

        int[][] result = new int[n][n];

        for (int i = 0; i < Math.ceilDiv(n, 2); i++) {
            int ri = rs;
            int ci = cs;

            /*to get the left to right row*/
            while (ci < ce && checkResultSize(itemInserted, totalElements)) {
                itemInserted++;
                result[ri][ci++] = itemInserted;
            }
            ci--;/*to keep the pointer on the last col*/
            ri++;/*to move to the next row*/

            /*to get the top to bottom col*/
            while (ri < re && checkResultSize(itemInserted, totalElements)) {
                itemInserted++;
                result[ri++][ci] = itemInserted;
            }
            ri--;
            ci--;

            /*to get the right to left row*/
            while (ci >= cs && checkResultSize(itemInserted, totalElements)) {
                itemInserted++;
                result[ri][ci--] = itemInserted;
            }
            ci++;
            ri--;

            /*to get the bottom to top col*/
            while (ri > rs && checkResultSize(itemInserted, totalElements)) {
                itemInserted++;
                result[ri--][ci] = itemInserted;
            }

            /*to shrink the row and col boundary by one layer*/
            rs += 1;
            cs += 1;
            re -= 1;
            ce -= 1;
        }
        return result;
    }

    private static boolean checkResultSize(int itemsInserted, int totalElements) {
        return itemsInserted < totalElements;
    }
}
