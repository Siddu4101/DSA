package org.example.neetcode150.arraysAndHashing;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ThreeSum {

    /*
     * Q.https://leetcode.com/problems/3sum/description/
     *15. 3Sum
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        Notice that the solution set must not contain duplicate triplets.

        Example 1:
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.
     * */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        log.info("The 3 sum list can be {}", threeSum(nums));
    }

    /*Approach 1:
     * Brut force: can have 3 nested for loop if nums[i] + nums[j] + nums[k] == 0 add them to the list and return
     * This is not efficient we won't do that Time complexity will be O(n3)
     * */

    /*Approach 2:
     * Take sum of 2 pair via 2 nested for loop except the sum of itself position
     * now check for the negation of the element present in the original array
     * if yes then we will have the pair of 3 nums which results to 0
     * but we need to avoid some extra computations like
     * a. same position duplicates like 1,0 and 0,1  in the 2 sum list
     * b. duplicate resulting list like [-1,2,-1] and [2,-1,-1]
     * */

    /*Due to the extra space it is exceeding the */
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        HashMap<Integer, Set<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < length; i++)
            indexMap.computeIfAbsent(nums[i], k -> new HashSet<>()).add(i);

        /*This exceeds the Memory as we have the (n-1)^2 extra space*/
        List<List<Integer>> twoSumArray = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                twoSumArray.add(Arrays.asList(nums[i] + nums[j], i, j));
            }
        }

        for (List<Integer> val : twoSumArray) {
            if (indexMap.containsKey(-1 * val.getFirst())) {
                for (int idx : indexMap.get(-1 * val.getFirst())) {
                    if (val.get(1) != val.get(2) && val.get(2) != idx && idx != val.get(1)) {
                        List<Integer> pos = Arrays.asList(nums[val.get(1)], nums[val.get(2)], nums[idx]);
                        pos.sort(Integer::compare);
                        res.add(pos);
                        break;
                    }
                }
            }
        }

        /*This exceeds the time as we have almost O(n3) */
//        Set<List<Integer>> res = new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 1; j < length; j++) {
//                int negateFor3Sum = (nums[i] + nums[j]) * -1;
//                if (indexMap.containsKey(negateFor3Sum)) {
//                    for (int idx : indexMap.get(negateFor3Sum)) {
//                        if (i != j && j != idx && idx != i) {
//                            List<Integer> pos = Arrays.asList(nums[i], nums[j], nums[idx]);
//                            pos.sort(Integer::compare);
//                            res.add(pos);
//                            break;
//                        }
//                    }
//                }
//            }
//        }

        return res.stream().toList();
    }
}
