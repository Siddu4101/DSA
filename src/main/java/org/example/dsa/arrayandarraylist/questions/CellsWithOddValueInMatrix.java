package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CellsWithOddValueInMatrix {
    /*
     * Q:https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/
     *1252. Cells with Odd Values in a Matrix
        There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
        For each location indices[i], do both of the following:
        Increment all the cells on row ri.
        Increment all the cells on column ci.
        Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
        Example 1:
        Input: m = 2, n = 3, indices = [[0,1],[1,1]]
        Output: 6
        Explanation: Initial matrix = [[0,0,0],[0,0,0]].
        After applying first increment it becomes [[1,2,1],[0,1,0]].
        The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
     *
     * */
    public static void main(String[] args) {
        int[][] indices = new int[][]{{0, 1}, {1, 1}};
        int m = 2;
        int n = 3;
        log.info("The odd element after the increment is {}", oddCells(m, n, indices));
    }

    public static int oddCells(int m, int n, int[][] indices) {

        /*
         * 1.first approach
         * a. get the total increment on each of the col and row
         * b. apply the total count on that particular row and col
         * c. then check the element is odd or not if odd add it to count and return
         *
         * 2.second approach
         * a. get the total increment on the each of the col and row
         * b. now run the nested loop directly on these row and col count and add them
         *    and check resulting item is even or odd if odd add it to the count and return
         *  NOTE: why it works ?
         *      ans: because the row and col count array itself represents the position of the matrix item
         *
         *
         * */
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        int[][] matrix = new int[m][n];

        /*first count the total increment on each col and row*/
        for (int[] item : indices) {
            rowCount[item[0]]++;
            colCount[item[1]]++;
        }

        log.info("the rowCount {} and colCount is {}", rowCount, colCount);

        /*then apply the row increment to whole row*/
        for (int i = 0; i < m; i++) {
            if (rowCount[i] != 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] += rowCount[i];
                }
            }
        }
        log.info("the matrix after row count increment {}", (Object) matrix);

        /*then apply the col increment to whole row*/
        for (int i = 0; i < n; i++) {
            if (colCount[i] != 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] += colCount[i];
                }
            }
        }

        log.info("the matrix after col count increment {}", (Object) matrix);
        /*count the odd elements in the matrix*/
        int count = 0;
        for (int[] items : matrix) {
            for (int item : items)
                count += (item % 2 == 0) ? 0 : 1;
        }

        return count;
    }
}