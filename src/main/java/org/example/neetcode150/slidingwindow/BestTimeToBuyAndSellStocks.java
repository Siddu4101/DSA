package org.example.neetcode150.slidingwindow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BestTimeToBuyAndSellStocks {

    /*Q :https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
        121. Best Time to Buy and Sell Stock
        You are given an array prices where prices[i] is the price of a given stock on the ith day.
        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

        Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */

    /*
     * NOTE HERE WE HAVEN'T USED THE SLIDING WINDOW TECHNIQUE TO SOLVE THE PROBLEM
     * */
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 8, 1, 6};//{7, 1, 5, 3, 6, 4};
        log.info("The max profit from viaBrutForce is {}", maxProfitViaBrutForce(prices));
        log.info("The max profit from PreMin and PostMax arrays is {}", maxProfitViaPreMinAndPostMaxArrays(prices));
        log.info("The max profit from twoPointer is {}", maxProfitViaTwoPointer(prices));
        log.info("The max profit from DynamicProgramming is {}", maxProfitViaDynamicProgramming(prices));
    }

    /*Approach 1: BrutForce
      1. use nested loop to see the difference of each element to each one if price[i] < price[i+1]
      2. which has the more difference send as max profit
    * */
    public static int maxProfitViaBrutForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) { /* -1 we need to have atleast 1 point to sell after buy*/
            for (int j = i + 1; j < prices.length; j++) {/*starting from i+1 as sell will happen only after buy*/
                if (prices[i] < prices[j]) {/*if sell value > buy then only compute profit and update max if it is actually greater*/
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
        }
        return maxProfit;
    }

    /*
     * TIME: O(n2)
     * SPACE: O(1)
     * TIME LIMIT EXCEEDED (NOT ACCEPTED)
     * */

    /*Approach : 02 Using PreMin and PostMax array
     1. Create the PreMin array and PostMax Array
     2. for each element pair check that PreMin element < PostMax element if yes cal the profit
     3. if profit > maxProfit replace it and send as result
     * */
    public static int maxProfitViaPreMinAndPostMaxArrays(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        int[] preMin = new int[length];
        int[] postMax = new int[length];

        int min = prices[0];
        int max = prices[length - 1];

        for (int i = 0; i < length; i++) {/*cal the pre min for i'th element*/
            min = Math.min(prices[i], min);
            preMin[i] = min;
        }
        for (int i = length - 1; i >= 0; i--) {/*cal the postMax for the i'th element*/
            max = Math.max(max, prices[i]);
            postMax[i] = max;
        }

        for (int i = 0; i < prices.length - 1; i++) {/*cal the profit if preMin is < postMax and update profit if it is > maxProfit*/
            if (preMin[i] < postMax[i]) {
                int profit = postMax[i] - preMin[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }

    /*
     * TIME: O(n)
     * SPACE: O(n)
     * */

    /*Approach: 03 TwoPointer
    1. start pointers l=0 and r=1
    2. if element at l < element at r then cal the profit and update if > maxProfit and update r++
    3. else update the l as r as and r as r = l + 1
    4. return maxProfit
    * */
    public static int maxProfitViaTwoPointer(int[] prices) {
        int maxProfit = 0;
        int l = 0;
        int r = l + 1;
        while (l < r && r < prices.length) {/* r < prices.length to avoid the indexOutOfBound*/
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);/*the r++ done outside the if and else*/
            } else {
                l = r;/* no need to set r to r++ as it will be done by below r++*/
            }
            r++;
        }
        return maxProfit;
    }

    /*
     * TIME: O(n)
     * SPACE: O(1)
     * */

    /*Approach:04 Dynamic Programming
     * 1. We know that the better price to buy is  = min price
     * 2. and profit =  current price - min value in the past
     * */
    public static int maxProfitViaDynamicProgramming(int[] prices) {
        int maxProfit = 0;
        int minBuyPrice = prices[0];
        int profit;
        for (int currentPrice : prices) {
            profit = currentPrice - minBuyPrice;/*cal the profit if we sell on the current day*/
            maxProfit = Math.max(profit, maxProfit);/*if this profit is more than the maxProfit made update it*/
            minBuyPrice = Math.min(currentPrice, minBuyPrice);/*min value seen in the past*/
        }
        return maxProfit;
    }

}
