package org.example.neetcode150;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SudokuValidator {

    /*
     * Q:https://leetcode.com/problems/valid-sudoku/
     *36. Valid Sudoku
        Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        Note:
        A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.

        Example 1:
        Input: board =
        [['5','3','.','.','7','.','.','.','.']
        ,['6','.','.','1','9','5','.','.','.']
        ,['.','9','8','.','.','.','.','6','.']
        ,['8','.','.','.','6','.','.','.','3']
        ,['4','.','.','8','.','3','.','.','1']
        ,['7','.','.','.','2','.','.','.','6']
        ,['.','6','.','.','.','.','2','8','.']
        ,['.','.','.','4','1','9','.','.','5']
        ,['.','.','.','.','8','.','.','7','9']]
        Output: true
     * */

    public static void main(String[] args) {
        char[][] board =
//                {{'.', '.', '.', '.', '5', '.', '.', '1', '.'}
//                        , {'.', '4', '.', '3', '.', '.', '.', '.', '.'}
//                        , {'.', '.', '.', '.', '.', '3', '.', '.', '1'}
//                        , {'8', '.', '.', '.', '.', '.', '.', '2', '.'}
//                        , {'.', '.', '2', '.', '7', '.', '.', '.', '.'}
//                        , {'.', '1', '5', '.', '.', '.', '.', '.', '.'}
//                        , {'.', '.', '.', '.', '.', '2', '.', '.', '.'}
//                        , {'.', '2', '.', '9', '.', '.', '.', '.', '.'}
//                        , {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};//==>False

                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};//  ==> True

        log.info("The given sudoku is {}", isValidSudokuBrutForce(board));
        log.info("The given sudoku via hashSet {}", isValidSudokuViaSet(board));
    }

    /*Approach 1
     * check for the duplicate or non compliant number in each row and col
     * check for the duplicate number in the 3x3 grid
     *
     * */

    public static boolean isValidSudokuBrutForce(char[][] board) {
        /*check the row and col number within the 1-9 or */
        Map<Character, Integer> rfrequency = new HashMap<>();
        Map<Character, Integer> cfrequency = new HashMap<>();

        /*Validate the column and row numbers*/
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                if (board[i][j] != '.') {
                    rfrequency.put(board[i][j], rfrequency.getOrDefault(board[i][j], 0) + 1);
                    cfrequency.put(board[j][i], cfrequency.getOrDefault(board[j][i], 0) + 1);
                }
            }
            if (checkForDuplicates(rfrequency) || checkForDuplicates(cfrequency))
                return false;
            log.info("Row frequency {}", rfrequency);
            log.info("Cow frequency {}", cfrequency);
            rfrequency.clear();
            cfrequency.clear();
        }

        /*Check for the 3X3 for duplicates*/
        for (int i = 0; i < 7; i += 3) {
            for (int j = 0; j < 7; j += 3) {
                if (check3x3Duplicates(board, i, j))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkForDuplicates(Map<Character, Integer> frequency) {
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getKey() != '.' && entry.getValue() > 1)
                return true;
        }
        return false;
    }

    /*check for 3x3 duplicates*/
    private static boolean check3x3Duplicates(char[][] board, int ri, int ci) {
        Map<Character, Integer> squareFrequency = new HashMap<>();
        for (int i = ri; i < ri + 3; i++) {
            for (int j = ci; j < ci + 3; j++) {
                squareFrequency.put(board[i][j], squareFrequency.getOrDefault(board[i][j], 0) + 1);
            }
        }
        log.info("Frequency for 3x3 square {}", squareFrequency);
        return checkForDuplicates(squareFrequency);
    }


    /*With better timing from 7ms to 2ms*/
    /*Approach 2:*/
    /*Using Set to check the duplicates and perform the similar checks as above */
    public static boolean isValidSudokuViaSet(char[][] board) {
        /*check the row and col number within the 1-9 or */
        Set<Character> rfrequency = new HashSet<>();
        Set<Character> cfrequency = new HashSet<>();

        /*Validate the column and row duplicates*/
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                if ((board[i][j] != '.' && !rfrequency.add(board[i][j])) || (board[j][i] != '.' && !cfrequency.add(board[j][i])))
                    return false;
            }
            rfrequency.clear();
            cfrequency.clear();
        }

        /*Check for the 3X3 for duplicates*/
        for (int i = 0; i < 7; i += 3) {
            for (int j = 0; j < 7; j += 3) {
                if (check3x3DuplicatesViaSet(board, i, j))
                    return false;
            }
        }
        return true;
    }

    /*check for 3x3 duplicates*/
    private static boolean check3x3DuplicatesViaSet(char[][] board, int ri, int ci) {
        Set<Character> frequency = new HashSet<>();
        for (int i = ri; i < ri + 3; i++) {
            for (int j = ci; j < ci + 3; j++) {
                if ((board[i][j] != '.' && !frequency.add(board[i][j])))
                    return true;
            }
        }
        return false;
    }
}
