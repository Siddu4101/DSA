package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinCostForStackingCoins {   /*
        * Q:https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/    *1217. Minimum Cost to Move Chips to The Same Position
        We have n chips, where the position of the ith chip is position[i].
        We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
        position[i] + 2 or position[i] - 2 with cost = 0.
        position[i] + 1 or position[i] - 1 with cost = 1.
        Return the minimum cost needed to move all the chips to the same position.

        Example 1:
        Input: position = [1,2,3]
        Output: 1
        Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
        Second step: Move the chip at position 2 to position 1 with cost = 1.
        Total cost is 1.

        Example 2:
        Input: position = [2,2,2,3,3]
        Output: 2
        Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.

        Example 3:
        Input: position = [1,1000000000]
        Output: 1    * */
    public static void main(String[] args) {
        int[] position = {6, 4, 7, 8, 2, 10, 2, 7, 9, 7};
        log.info("Minimum cost needed to stack up the coins {}", minCostToMoveChips(position));
    }

    private static int minCostToMoveChips(int[] position) {

//        /*NOT WORKING*/
//        /*REASON: need to add another case of cost on even and odd max position separately for shifting then take min out of it*/
//        /*
//         * Approach 01
//         * 1. find the position which has max coins
//         * 2. find those position which had odd difference from the max coins position
//         * 3. sum them to get the min cost
//         * 4. as even position coins shifted with 0 cost
//         * */
//        /*convert position array into map with count of coins on each position*/
//        Map<Integer, Integer> countAndIndexOfCoins = new TreeMap<>();
//        int maxCoins = 0;
//        position = Arrays.stream(position).sorted().toArray();
//        log.info("Positions {}", position);
//        for (int n : position) {
//            int coinCount = countAndIndexOfCoins.get(n) != null ? countAndIndexOfCoins.get(n) + 1 : 1;
//            if (coinCount > maxCoins)
//                maxCoins = coinCount;
//            countAndIndexOfCoins.put(n, coinCount);
//        }
//        log.info("Max coins {}", maxCoins);
//
//        /*convert the position and coin count into a array [position1, count1, ...] and also get the max coin present on a location */
//
//        int[] index = {0};
//        int[] positionAndCount = new int[countAndIndexOfCoins.size() * 2];
//        countAndIndexOfCoins.forEach((key, value) -> {
//            positionAndCount[index[0]++] = key;
//            positionAndCount[index[0]++] = value;
//        });
//
//        log.info("The array build out of map {}", Arrays.toString(positionAndCount));
//
//        /*
//         * find max coined position
//         * */
//        int maxCoinPosition = 0;
//        for (int i = positionAndCount.length - 1; i >= 0; i -= 2) {
//            if (positionAndCount[i] == maxCoins) {
//                maxCoinPosition = i - 1;
//                break;
//            }
//        }
//
//        /*cost needed to shift coins on left */
//        int cost = 0;
//        log.info("max coins position {} ", maxCoinPosition);
//        for (int i = maxCoinPosition - 1; i >= 0; i -= 2) {
//            if ((positionAndCount[maxCoinPosition] % 2 != 0 && positionAndCount[i - 1] % 2 == 0)
//                    || (positionAndCount[maxCoinPosition] % 2 == 0 && positionAndCount[i - 1] % 2 != 0))
//                cost += positionAndCount[i];
//        }
//
//        log.info("cost needed for shift left positioned coins {}", cost);
//
//        /*cost needed to shift coins on right*/
//        for (int i = maxCoinPosition + 1; i < positionAndCount.length; i += 2) {
//            if ((positionAndCount[maxCoinPosition] % 2 != 0 && positionAndCount[i - 1] % 2 == 0)
//                    || (positionAndCount[maxCoinPosition] % 2 == 0 && positionAndCount[i - 1] % 2 != 0))
//                cost += positionAndCount[i];
//        }
//        log.info("cost needed for shift right positioned coins {}", cost);

        /*WORKING*/
        /*
         * Approach 02
         * 1. each odd to odd or even to even jump cost = 0
         * 2. each even to odd ot odd to even jump cost = 1
         * 3. so sum up all the odd and even separately
         * 4. and to place even on top of odd or odd on top of even it cost those pennies return that
         * */

        int odd = 0;
        int even = 0;
        for (int j : position) {
            if (j % 2 == 0)
                even++;
            else
                odd++;
        }
        return Math.min(odd, even);
    }
}
