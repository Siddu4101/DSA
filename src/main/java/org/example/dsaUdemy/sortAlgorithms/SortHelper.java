package org.example.dsaUdemy.sortAlgorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class SortHelper {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(String message, int[] nums) {
        log.info("{} : {}", message, Arrays.toString(nums));
    }
}
