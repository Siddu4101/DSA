package org.example.patternVice.slidingWindow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxPointsObtainFromCard {

    /*
     * Q: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
     *1423. Maximum Points You Can Obtain from Cards
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Example 1:
Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

Example 2:
Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
     *
     * */
    public static void main(String[] args) {
        int[] cardPoints = {2, 11, 4, 5, 3, 9, 2};
        int k = 3;
        log.info("The max point can be picked is {}", maxPointsFromCard(cardPoints, k));
    }

    /*
     * Approach: 01:
     * 1. if len < k return 0, cal the right subWindow sum consider as max for now
     * 2. if len = k that is the max sum return it
     * 3. now start i= start of right subWindow j = start of the array
     * 4. remove the ith element and add the jth element to move the window till i reaches the end if u find any sum max in this window mark it max
     * */
    private static int maxPointsFromCard(int[] cardPoints, int k) {
        int length = cardPoints.length;

        if (length < k)
            return 0; /* if len < k return 0*/

        int rightSum = 0;
        for (int i = length - k; i < length; i++)
            rightSum += cardPoints[i]; /*right window sum*/

        if (length == k)
            return rightSum; /* if k = len return this as max */

        int j = 0; /*start from left 0th index*/
        int i = length - k - j; /* start from right sub array start */
        int maxSum = rightSum;

        while (i < length) { /* while i reaches the end */
            rightSum -= cardPoints[i]; /* remove the right window element*/
            rightSum += cardPoints[j]; /* add the left window element */

            if (rightSum > maxSum)
                maxSum = rightSum; /* if sum is max change it*/

            j++; /*move to the next window*/
            i++;
        }

        return maxSum;
    }
}