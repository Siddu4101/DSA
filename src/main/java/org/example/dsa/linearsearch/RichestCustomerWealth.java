package org.example.dsa.linearsearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RichestCustomerWealth {

    /*
       Q.1672. Richest Customer Wealth
       Input: accounts = [[1,2,3],[3,2,1]]
       Output: 6
       Explanation:
       1st customer has wealth = 1 + 2 + 3 = 6
       2nd customer has wealth = 3 + 2 + 1 = 6

       Input: accounts = [[1,5],[7,3],[3,5]]
       Output: 10
       Explanation:
       1st customer has wealth = 6
       2nd customer has wealth = 10
       3rd customer has wealth = 8
       The 2nd customer is the richest with a wealth of 10.
       Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
       Output: 17
     * */

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {3, 2, 1}};
        log.info("The richest man wealth is {}", wealthCalculator(arr1));

        int[][] arr2 = {{1, 5}, {7, 3}, {3, 5}};
        log.info("The richest man wealth is {}", wealthCalculator(arr2));

        int[][] arr3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        log.info("The richest man wealth is {}", wealthCalculator(arr3));
    }

    static int wealthCalculator(int[][] arr) {
        int maxWealth = 0;
        for (int[] ar : arr) {
            int eachManWealth = 0;
            for (int a : ar) {
                eachManWealth += a;
            }
            if (eachManWealth > maxWealth)
                maxWealth = eachManWealth;
        }
        return maxWealth;
    }
}
