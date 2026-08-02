package org.example.patternVice.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class TrappingRainWater {
    /*
    * Q:
    * 42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
    *
    * */

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        log.info("The total trapped rain water is {}", trap(height));
        log.info("The two pointer trapped water {}", trapWithTwoPointer(height));
    }

    /*
     * Approach: 01
     * 1. cal the prefixMax and suffixMax for each location
     * 2. for each poistion check the possible water can trap = min(leftMax, rightMax) - height[position] if (height[position] > min(leftMax,rightMax)) add it to total water trapped
     *
     * */
    public static int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int lm = 0;
        int rm = 0;
        int totalWaterTrapped = 0;

        for (int i = 0, j = height.length - 1; i < height.length; i++, j--) {
            leftMax[i] = lm;
            lm = Math.max(height[i], lm);

            rightMax[j] = rm;
            rm = Math.max(height[j], rm);
        }

        System.out.println("Left max for any given point " + Arrays.toString(leftMax));
        System.out.println("right max for any given point " + Arrays.toString(rightMax));

        for (int i = 0; i < height.length; i++) {
            int minWaterCanTrap = Math.min(leftMax[i], rightMax[i]);
            if (minWaterCanTrap > height[i])
                totalWaterTrapped += minWaterCanTrap - height[i];
        }

        return totalWaterTrapped;
    }


    /*
     * Approach : 02
     * 1. set 2 pointer left = 0 right = len -1 and 2 max pointer leftMax = startHeight rightMax = endHeight
     * 2. if height of the max of the left or right is less move that pointer
     * 3. cal the max height at that location by it's height and and the maxPointer at that side and subtract by height of it to cal the water aat that position
     * */
    public static int trapWithTwoPointer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWaterTrapped = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);/*The max water that this location it can hold wrt left max*/
                totalWaterTrapped += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);/*The max water that this location it can hold wrt right max*/
                totalWaterTrapped += rightMax - height[right];
            }
        }

        return totalWaterTrapped;
    }
}
