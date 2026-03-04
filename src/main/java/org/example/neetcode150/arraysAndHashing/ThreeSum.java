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
        int[] nums =
//                {0, 0, 0};
                {-1, 0, 1, 2, -1, -4};
        log.info("The 3 sum list can be {}", threeSum(nums));
        log.info("The 3 sum list can be {} via 3 pointer method", threeSumViaThreePointerMethod(nums));
    }

    /*WORKING SOLUTION*/
    private static List<List<Integer>> threeSumViaThreePointerMethod(int[] nums) {
        /*Approach:
         * 1. sort the nums to use this 3 pointer approach
         * 2. set a pointer at the starting i = 0 and next 2 pointer at j = i + 1 and k = length - 1
         * 3. now try to check for the sum = nums[i] + nums[j] + nums[k] == 0 if yes just add it in the result and break that iteration
         * 4. if sum < 0 while nums[j] == nums[j+1] increment the j and after loop also increment by 1 so that we can avoid the duplicates pair of 3 in the result
         * 5. if sum > 0 while nums[k] == nums[k-1] decrement the k and after loop also decrement by 1 so that we can avoid the duplicates pair of 3 in the result
         * 6. these increment and decrement of j and k should happen when it satisfies the j < k
         * 7. while nums[i] == nums[i+1] and i < k increment the i and after loop also decrement by 1 so that we can avoid the duplicates pair of 3 in the result
         * 8. and exit the program once you find nums[i] > 0 because after that u will find all the numbers as 0 or > 0 so sum can't be 0 anymore for any addition
         * */
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        /*initialize the pointers*/
        int i = 0;
        int j = i + 1;
        int k = length - 1;

        /*sort the nums array*/
        Arrays.sort(nums);
        while (nums[i] <= 0) { /*if start is > 0 next number >0 so it's sum can never be 0*/
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) /* This j decrement is to get all the possible pair for that iteration of the i*/
                        j++;
                    j++;
                } else if (sum < 0) {
                    while (j < k && nums[j] == nums[j + 1]) /*to avoid the duplicates*/
                        j++;
                    j++; /*just next to duplicate */
                } else {
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    k--;
                }
            }
            while (i < length - 4 && nums[i] == nums[i + 1]) /* -4 bcz we are doing i = i +1 in next step also ( so it will be i = 2 inside the while) so next step i = 3  so it will be lft with 2 more place for j and k*/
                i++;
            if (i < length - 4) {
                i = i + 1;/*just next to duplicate*/
                j = i + 1;
                k = length - 1;
            } else
                return result;
        }
        return result;
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
