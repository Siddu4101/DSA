package org.example.neetcode150.twopointer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrappingRainWater {

    /*Q: https://leetcode.com/problems/container-with-most-water/
        42. Trapping Rain Water
        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

        Example 1:
        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6
        Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

        Example 2:
        Input: height = [4,2,0,3,2,5]
        Output: 9
        */

    /*
     * We need to find the total water present between the bars
     * */

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};//{4, 2, 0, 3, 2, 5};
        log.info("The total water trapped under the bar is {} via BrutForce", trapViaBrutForce(height));
        log.info("The total water trapped under the bar is {} via PrefixAndSuffixMax ", trapViaPrefixAndSuffixMax(height));
        log.info("The total water trapped under the bar is {} via TwoPointer ", trapViaTwoPointer(height));
    }

    /*Approach:01 Brut Force:
     * 1. To cal the water present at particular index we can do something like = min(leftMaxHeight, rightMaxHeight) - height[i]
     * 2. To cal the height of the left and right for each index i and then apply the formula and result is summed to get the final are
     * 3. Reason  min(leftMaxHeight, rightMaxHeight) - height[i]  We know that max we can keep the water with lesser height (min(leftMaxHeight, rightMaxHeight)) and removing the height of the current block as it is solid here
     *   it can't hold data for that height space so we will remove it (- height[i]) this gives the area of the water present at that index
     * 4. if right and left max not exist current value will be considered as max for that iteration as it align with formula
     * */
    public static int trapViaBrutForce(int[] height) {
        int totalAreaOfWaterTrapped = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j <= i; j++) /*check left max including the current element(<= i) of the iteration*/
                if (height[j] > leftMax)
                    leftMax = height[j];
            for (int k = i; k < height.length; k++)/*check right max including the current element(k=i) of the iteration*/
                if (height[k] > rightMax)
                    rightMax = height[k];

            totalAreaOfWaterTrapped += Math.min(leftMax, rightMax) - height[i];
        }
        return totalAreaOfWaterTrapped;
    }

    /*
     * TIME: O(n2) --> as we nested loop which runs for each element
     * Space: O(1) --> no extra space
     * TIME LIMIT EXCEEDED
     * */


    /*Approach:01 Prefix and Suffix Max array:
    1. Here also the formula remain same but instead of cal the right and left max element we will do it before only in one shot
        as prefix and suffix max array which will store the max right and left element for i
    2. and now apply the formula for area cal.
    3. This reduced the duplicate recalculation of the boundaries to O(n)
     * */
    public static int trapViaPrefixAndSuffixMax(int[] height) {
        int length = height.length;
        int[] prefixMax = new int[length];
        int[] suffixMax = new int[length];
        int totalAreaOfWaterTrapped = 0;
        int max = 0;

        /*cal the prefix and suffix max for each i'th element*/
        for (int i = 0; i < length; i++) { /*for the element if is it start or end position, left or right max are itself */
            max = Math.max(height[i], max);
            prefixMax[i] = max;
        }
        max = 0;
        for (int j = length - 1; j >= 0; j--) {
            max = Math.max(height[j], max);
            suffixMax[j] = max;
        }

        for (int i = 0; i < height.length; i++) {
            totalAreaOfWaterTrapped += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return totalAreaOfWaterTrapped;
    }

    /*
     * TIME: O(n) --> done only single iteration for each operation like prefix and suffix max and also for the are cal
     * SPACE: O(n) --> took extra n + n space for prefix and suffix Max storage
     * */


    /*Approach:03 TwoPointer:
    1. The area of the rain trapped at particular index/block while checking from left side = max height from left side - height of the current block
    2. from right side = max height from right side - height of the current block
    3. we will cal this for each index moving from left and right towards center until i < j and sum whatever the water trapped will give us the res
    4. if the block of left is smaller move left -> right and if right is smaller mover right to left
    5. for equal case anything is fine we will follow right to left
     * */
    public static int trapViaTwoPointer(int[] height) {
        int length = height.length;
        int l = 0;
        int r = length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int totalAreaOfWaterTrapped = 0;

        while (l < r) {
            if (leftMax < rightMax) { /*if height of the left is less move towards right */
                l++;
                leftMax = Math.max(leftMax, height[l]);
                totalAreaOfWaterTrapped += leftMax - height[l];/*at each position what is amount of water from left side MAX_LEFT - CURRENT_HEIGHT */
            } else {/*if height of the right is more move towards left*/
                r--;
                rightMax = Math.max(rightMax, height[r]);
                totalAreaOfWaterTrapped += rightMax - height[r];/*at each position what is amount of water from right side MAX_RIGHT - CURRENT_HEIGHT */
            }
        }
        return totalAreaOfWaterTrapped;
    }

    /*
     * TIME: O(n) --> done only single iteration from both sides
     * SPACE: O(1) --> no extra space has taken
     * BEST SOLUTION
     * */
}
