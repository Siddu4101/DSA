package org.example.patternVice.twoPointer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContainerWithMostWater {
    /*
     *Q:https://leetcode.com/problems/container-with-most-water/description/
     *11. Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
     *
     * */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        log.info("The max water can trap between 2 container is {}", maxArea(height));
    }

    /*
     * Approach:
     * 1. start left = 0 and right = len - 1 while left < right
     * 2. cal area if it newArea > maxArea replace it with New area
     * 3. then move the pointer of the side which has less height
     * */

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right])
                left++;
            else
                right--;

        }

        return maxArea;
    }
}
