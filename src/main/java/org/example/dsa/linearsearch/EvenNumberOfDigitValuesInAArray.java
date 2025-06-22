package org.example.dsa.linearsearch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class EvenNumberOfDigitValuesInAArray {

    /*
     * Q.1295. Find Numbers with Even Number of Digits
     * Input: nums = [12,345,2,6,7896]
     * Output: 2
     * */

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896, -39, -1000};
        log.info("number of even digit numbers present in {} is {}", Arrays.toString(nums), findNumbers(nums));
    }

    static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (getNumberOfDigits(num) % 2 == 0)
                count++;
        }
        return count;
    }

    static int getNumberOfDigitsSecondWay(int num) {
        if (num == 0)
            return 1;
        if (num < 0)
            num = num * -1;
        int digits = 0;
        while (num > 0) {
            num = num / 10;
            digits++;
        }
        return digits;
    }

    /*Alternative to get the number of digits in a number*/
    static int getNumberOfDigits(int num) {
        /*because log10 representation gives 10^n so n gives the number of digits*/
        return (int) Math.floor(Math.log10(num) + 1);
    }
}
