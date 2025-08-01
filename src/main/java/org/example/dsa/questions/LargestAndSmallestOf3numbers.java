package org.example.dsa.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LargestAndSmallestOf3numbers {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        log.info("minimum {}", getMinimum(a, b, c));
        log.info("maximum {}", getMaximum(a, b, c));
    }

    private static int getMinimum(int a, int b, int c) {
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;

        return max;
    }

    private static int getMaximum(int a, int b, int c) {
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;

        return min;
    }
}
