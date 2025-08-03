package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumbersSmallerThanCurrentNumber {
    /*
     * Q:https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
     * 1365. How Many Numbers Are Smaller Than the Current Number
        Easy
        Topics
        premium lock icon
        Companies
        Hint
        Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
        Return the answer in an array.
        Example 1:
        Input: nums = [8,1,2,2,3]
        Output: [4,0,1,1,3]
        Explanation:
        For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
        For nums[1]=1 does not exist any smaller number than it.
        For nums[2]=2 there exist one smaller number than it (1).
        For nums[3]=2 there exist one smaller number than it (1).
        For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
     * */
    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};
        log.info("array of counts which have the count of numbers less than the given number {}", smallerNumbershaveThanCurrent(nums));
    }

    public static int[] smallerNumbershaveThanCurrent(int[] nums) {

        /*first approach*/
//        int[] temp = nums.clone();
//        Arrays.sort(nums);
//        log.info("original {} tmep {}", nums, temp);
//        int[] ans = new int[nums.length];
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[i] > nums[j])
//                    ans[i]++;
//            }
//        }
//        int[] res = new int[nums.length];
//        for (int i = 0; i < temp.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] == temp[i])
//                    res[i] = ans[j];
//            }
//        }

        /*Second approach*/

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int num : nums) {
                if (nums[i] > num)
                    ans[i]++;
            }
        }
        return ans;
    }
}
