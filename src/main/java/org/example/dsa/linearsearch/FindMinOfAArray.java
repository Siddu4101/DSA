package org.example.dsa.linearsearch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class FindMinOfAArray {
    public static void main(String[] args) {
        int[] arr = {10, 3, 6, -1, 34, 66, 42, 7, 88, 25};
        log.info("Minimum value of a array {} is {}", Arrays.toString(arr), minOfArray(arr));
        arr = new int[]{};
        log.info("Minimum value of a array {} is {}", Arrays.toString(arr), minOfArray(arr));
    }

    private static int minOfArray(int[] arr) {
        if (arr.length == 0)
            return Integer.MIN_VALUE;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }
}
