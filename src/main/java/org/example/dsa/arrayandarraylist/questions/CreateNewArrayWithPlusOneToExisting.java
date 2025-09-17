package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
public class CreateNewArrayWithPlusOneToExisting {
    /*
     * Q:https://leetcode.com/problems/plus-one/
     *66. Plus One
        You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
        Increment the large integer by one and return the resulting array of digits.

        Example 1:
        Input: digits = [1,2,3]
        Output: [1,2,4]
        Explanation: The array represents the integer 123.
        Incrementing by one gives 123 + 1 = 124.
        Thus, the result should be [1,2,4].

        Example 2:
        Input: digits = [4,3,2,1]
        Output: [4,3,2,2]
        Explanation: The array represents the integer 4321.
        Incrementing by one gives 4321 + 1 = 4322.
        Thus, the result should be [4,3,2,2].

        Example 3:
        Input: digits = [9]
        Output: [1,0]
        Explanation: The array represents the integer 9.
        Incrementing by one gives 9 + 1 = 10.
        Thus, the result should be [1,0].
     * */
    public static void main(String[] args) {
        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        log.info("The new plus one array is {}", plusOne(digits));

    }

    private static int[] plusOne(int[] digits) {
        StringBuilder number = new StringBuilder();
        for (int n : digits)
            number.append(n);
        BigInteger num = new BigInteger(number.toString()).add(BigInteger.valueOf(1L));
        String numStr = num.toString();
        int[] res = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++)
            res[i] = numStr.charAt(i) - '0';

        /*
         * second approach
         * */
        /*
       for(int i=digits.length-1;i>=0;i--){
        if(digits[i]<9){
          digits[i]++;
          return digits;
        }
        digits[i]=0;
      }
       digits=new int[digits.length+1];
      digits[0]=1;
      return digits;
        * */
        return res;
    }
}
