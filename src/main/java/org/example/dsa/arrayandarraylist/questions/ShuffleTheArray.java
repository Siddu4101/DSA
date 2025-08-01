package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShuffleTheArray {
    /*
     * Q:https://leetcode.com/problems/shuffle-the-array/
     *Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
        Return the array in the form [x1,y1,x2,y2,...,xn,yn].
        Example 1:
        Input: nums = [2,5,1,3,4,7], n = 3
        Output: [2,3,5,4,1,7]
        Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

        Example 2:
        Input: nums = [1,2,3,4,4,3,2,1], n = 4
        Output: [1,4,2,3,3,2,4,1]
     * */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        log.info("shuffled array is {}", shuffle(nums, 3));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int index = 0;
        for (int i = 0, j = n; j < 2 * n; i++, j++) {
            ans[index++] = nums[i];
            ans[index++] = nums[j];
        }
        return ans;
    }
}
