package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GetTheArrayAfterAddingNumberToArrayNumber {
    /*
     * Q:https://leetcode.com/problems/add-to-array-form-of-integer/
     *989. Add to Array-Form of Integer
        The array-form of an integer num is an array representing its digits in left to right order.
        For example, for num = 1321, the array form is [1,3,2,1].
        Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

        Example 1:
        Input: num = [1,2,0,0], k = 34
        Output: [1,2,3,4]
        Explanation: 1200 + 34 = 1234

        Example 2:
        Input: num = [2,7,4], k = 181
        Output: [4,5,5]
        Explanation: 274 + 181 = 455
     * */
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3};
        int k = 516;
        log.info("The resulting array after doing the sum is {}", addToArrayForm(num, k));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {

        /*
         * Approach 1
         * */
        ArrayList<Integer> res = new ArrayList<>();
        StringBuilder arrayNumber = new StringBuilder();
        for (int i : num)
            arrayNumber.append(i);
        BigInteger arraySumPlusKey = new BigInteger(arrayNumber.toString()).add(new BigInteger(String.valueOf(k)));
        for (char i : String.valueOf(arraySumPlusKey).toCharArray())
            res.add(Integer.valueOf(String.valueOf(i)));
        return res;
    }
}
