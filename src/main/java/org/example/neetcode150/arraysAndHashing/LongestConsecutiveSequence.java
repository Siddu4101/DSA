package org.example.neetcode150.arraysAndHashing;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class LongestConsecutiveSequence {
    /*
     * Q: https://leetcode.com/problems/longest-consecutive-sequence/description/
     *128. Longest Consecutive Sequence
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        You must write an algorithm that runs in O(n) time.
        Example 1:
        Input: nums = [100,4,200,1,3,2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

        Example 2:
        Input: nums = [0,3,7,2,5,8,4,6,0,1]
        Output: 9
     * */
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2};
//                {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
//                {100, 4, 200, 1, 3, 2};
        log.info("Longest consecutive sequence is {}", longestConsecutive(nums));
        log.info("Longest consecutive sequence is via Set {}", longestConsecutiveSequenceViaSet(nums));
        log.info("Longest consecutive sequence is via Map {}", longestConsecutiveSequenceViaHashMap(nums));
    }

    /*Approach 1*/
    /*
     * Sort the array and then compare adjacent numbers if difference is 1 store the sequence count and set the max if sequenceCount > max
     * using sequence count to store multiple sequence may present in single array max will store the highest possible one
     * but this is better approach as array sort is speed as per runtime but time complexity is nlog(n) as sorting is taking that
     * */
    public static int longestConsecutive(int[] nums) {
        int max = 0;
        int sequenceCount = 0;
        if (nums.length == 0) return 0;
        nums = Arrays.stream(nums).distinct().sorted().toArray();/*This sort takes nlog(n) time*/
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                sequenceCount++;
                if (sequenceCount > max) max = sequenceCount;
            } else sequenceCount = 0;
        }
        return max + 1;
    }

    /*Approach 2:*/
    /*
     * We wil have add these elements to a set for distinct and easy lookup O(1)
     * then we will check is the num - 1 present in the set if yes then we can ignore that as it can't be the starting of the sequence
     * if not then it should be starting sequence
     * once we have the starting numbers we will check for each start number what is the sequence count and which has the max we will return that
     * */

    public static int longestConsecutiveSequenceViaSet(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> input = new HashSet<>();
        /*Add items to set for distinct and easy access*/
        for (int n : nums)
            input.add(n);

        /*if num - 1 not present in the set then it is the stating point of a sequence*/
        int sequenceCount = 0;
        int maxCount = 0;
        for (int num : input) {
            if (!input.contains(num - 1)) {
                /*for each starting point of the */
                while (input.contains(num)) {/*from the set check do we have next element of the sequence*/
                    sequenceCount++;
                    num++;/*to check is there any element present for the sequence*/
                }
                if (sequenceCount > maxCount)
                    maxCount = sequenceCount;/*if any senescence has the max count then use it for the return */
                sequenceCount = 0;/*for each start sequence we need to reset the count flag*/
            }
        }
        return maxCount;
    }

    /*Approach : 3*/

    /*
     * ViaHashMap here we will store the numbers and there right and left boundaries with their max sequence count
     * whenever we encounter the number either it is a middle one start of the sequence or the end of the sequence based on that we update the right left or both boundaries sequence count
     * */
    public static int longestConsecutiveSequenceViaHashMap(int[] nums) {
        HashMap<Integer, Integer> boundaries = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!boundaries.containsKey(num)) {/*To avoid the duplicate numbers*/
                /*to get the length of the sequence we need current (1) + left boundarie sequence count and right one*/
                Integer leftBoundary = boundaries.getOrDefault(num - 1, 0);
                Integer rightBoundary = boundaries.getOrDefault(num + 1, 0);
                int sequenceLength = leftBoundary + rightBoundary + 1;
                boundaries.put(num, sequenceLength);

                /*update the left and right boundaries accordingly*/
                boundaries.put(num - leftBoundary, sequenceLength);
                boundaries.put(num + rightBoundary, sequenceLength);
                res = Math.max(sequenceLength, res);
            }
        }
        return res;
    }
}
