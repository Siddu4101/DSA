package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class LuckyNumberFrom2DArray {
    /*
     * Q:https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
     *1380. Lucky Numbers in a Matrix
        Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
        A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
        Example 1:

        Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
        Output: [15]
        Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

        Example 2:
        Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
        Output: [12]
        Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
     * */
    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        log.info("the lucky numbers are {}", luckyNumbers(matrix));
    }

    private static List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        int[] min = new int[rows];
        int[] max = new int[col];
        int maxInCol;
        int minInRow;
        int index = 0;

        for (int i = 0; i < rows; i++) {
            minInRow = matrix[i][0];
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] < minInRow)
                    minInRow = matrix[i][j];
            }
            min[index++] = minInRow;
        }
        index = 0;
        for (int i = 0; i < col; i++) {
            maxInCol = matrix[0][i];
            for (int j = 1; j < rows; j++) {
                if (matrix[j][i] > maxInCol)
                    maxInCol = matrix[j][i];
            }
            max[index++] = maxInCol;
        }

        log.info("The min and max array for each row and col are {} and {}", Arrays.toString(min), Arrays.toString(max));

        List<Integer> res = new ArrayList<>();
        for (int k : min) {
            for (int i : max) {
                if (k == i)
                    res.add(k);
            }
        }
        return res;
    }
}
