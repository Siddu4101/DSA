package org.example.neetcode150.twopointer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContainerWithMostWater {

    /*
     * Q:https://leetcode.com/problems/container-with-most-water/description/
     * 11. Container With Most Water
     You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     Find two lines that together with the x-axis form a container, such that the container contains the most water.
     Return the maximum amount of water a container can store.
     Notice that you may not slant the container.
     Example 1:
     Input: height = [1,8,6,2,5,4,8,3,7]
     Output: 49
     Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     Here we will have x-y graph where x is the index and y is the actual array height now we need to find the area where height * width is max in this case it is
     =(8-1) * min(8,7) = 7 * 7 = 49
     =(index) * (height)
     = width * height

     Example 2:
     Input: height = [1,1]
     Output: 1
     * */

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        log.info("The the max container area is {} from BrutForce", maxAreaFromBrutForce(height));
        log.info("The the max container area is {} from TwoPointer", maxAreaFromTwoPointer(height));
        log.info("The the max container area is {} from TwoPointerEnhanced", maxAreaFromTwoPointerEnhanced(height));
    }

    /*Approach:01 Brut Force
     * 1. for each possible pair find the area = (j-i) * min(height(i),height(j))
     * 2. and update the max based on the max value and return
     * min(height(i),height(j)) bcz we know that the water can stay till we have the min height present on either side
     * */
    public static int maxAreaFromBrutForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) { /* j=i+1 as we have already computed the area between the i and j in previous iterations*/
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    /*
     * TIME: O(n2) --> nested loop and all the pair evaluation
     * SPACE: O(1) --> no extra space used
     * TIME LIMIT EXCEEDED (solution expected to be O(n))
     * */


    /*Approach:02 Two Pointer
    1.start from the broader area start to end i=0 and j=len-1
    2. compute the area = (j-i) * min(height(i),height(j)) if it is max than than the max area replace itwith this
    3. then move the pointer which has less height bcz we know less height is the one which impacts the area
    4. if heights are equal move any of them i prefer move j to the left
    * */
    public static int maxAreaFromTwoPointer(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, area);
            if (height[i] >= height[j]) /*if height of i is greater or equal to j move j to left*/
                j--;
            else/*else move i to right*/
                i++;
        }
        return maxArea;
    }

    /*
     * TIME: O(n) --> in a single iteration we got the answer
     * SPACE: O(1) --> no extra space is used
     * */

    /*Enhanced version:
     * We know that if the area's subset has the less height the outer area will be the solution always
     * because we move any right or the left pointers to the inwards then still the max are remains the outer one
     * so we can take it as advantage and if any inward height has this we will blindly move the pointers
     * */
    public static int maxAreaFromTwoPointerEnhanced(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = (j - i) * minHeight;
            maxArea = Math.max(maxArea, area);
            while (i < j && height[i] <= minHeight) /*if the boundary has more height it will have the more width and if the subset or the inner stick has less height we will get less entry for sure so skip that */
                i++;
            while (i < j && height[j] <= minHeight)/*doing the same for the if height is less for next elements just skip them and move on as are will come less inside it*/
                j--;
        }
        return maxArea;
    }
}
