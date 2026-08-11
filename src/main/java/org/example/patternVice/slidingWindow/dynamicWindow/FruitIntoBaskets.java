package org.example.patternVice.slidingWindow.dynamicWindow;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class FruitIntoBaskets {
    /*
     * Q:https://leetcode.com/problems/fruit-into-baskets/
     *904. Fruit Into Baskets
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Example 1:
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
*
Example 2:
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
*
Example 3:
Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
     *
     * */

    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        log.info("The max fruits with 2 types we can hold in 2 baskets are {}", totalFruit(fruits));

    }

    /*
     * Approach: 01
     * 1. start with  i =0 and keep a start pointer for the window start to remove elements and maxFruits for max count
     * 2. for each fruit type add a frequency in the map
     * 3. if frequency.size > 2 we have 1 extra type of fruit so remove fruits and once reach count = 0 remove from the map so we have 2 kinds and update the start accordingly
     * 4. after each update in the map update the max
     * */

    /*
     * T: O(n)
     * S: (1)
     * */
    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int start = 0;
        HashMap<Integer, Integer> fruitsTypeFrequency = HashMap.newHashMap(3);

        for (int i = 0; i < fruits.length; i++) {
            fruitsTypeFrequency.put(fruits[i], fruitsTypeFrequency.getOrDefault(fruits[i], 0) + 1); /* each fruit freq*/

            if (fruitsTypeFrequency.size() > 2) { /* if > 2 kinds of fruit present*/
                while (fruitsTypeFrequency.size() > 2) { /* remove fruits from start till we have 2 kinds*/
                    fruitsTypeFrequency.put(fruits[start], fruitsTypeFrequency.get(fruits[start]) - 1);
                    if (fruitsTypeFrequency.get(fruits[start]) == 0) /*if fruit count = 0 remove from the map*/
                        fruitsTypeFrequency.remove(fruits[start]);

                    start++; /* to be in sync with start elements which have removed*/
                }
            }

            maxFruits = Math.max(maxFruits, i - start + 1);/* update the max fruits*/
        }

        return maxFruits;
    }
}
