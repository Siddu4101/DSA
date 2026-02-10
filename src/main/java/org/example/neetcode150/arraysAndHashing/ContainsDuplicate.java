package org.example.neetcode150.arraysAndHashing;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ContainsDuplicate {

    /*
     * 1.https://leetcode.com/problems/contains-duplicate/description/
     *
     * 217. Contains Duplicate
        Easy
        Topics
        premium lock icon
        Companies
        Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        Example 1:
        Input: nums = [1,2,3,1]
        Output: true
        Explanation:
        The element 1 occurs at the indices 0 and 3.
     *
     * */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        log.info("contains duplicate ? via streams and group by {}", viaStreamsAndGruopBy(nums));

        log.info("contains duplicate ? via count and distinct count {}", viaCountAndDistinctCount(nums));
        log.info("contains duplicate ? via hash set contains method {}", viaHasSet(nums));
    }

    private static boolean viaCountAndDistinctCount(int[] nums) {
        /*2. we can take the distinct of the array if it size reduces then we have the duplicates in it*/
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    private static boolean viaStreamsAndGruopBy(int[] nums) {
        /*1. Using streams and group by*/
        Map<Integer, Long> collect = Arrays.stream(nums).parallel().boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        log.info("The grouped data looks like {}", collect);
        return collect.values().stream().anyMatch(x -> x > 1);
    }

    public static boolean viaHasSet(int[] nums) {
        /*3. we can use the HashSet were we will keep the elements if the element already present before keeping it then return ture as it's duplicate*/
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (!integers.add(num)) /*returns false if element already present*/
                return true;
        }
        return false;
    }
}

