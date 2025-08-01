package org.example.dsa.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactorialOfANumber {
    public static void main(String[] args) {
        int num = 3;
        log.info("factorial of {} is {}", num, factorial(num));
    }

    static int factorial(int num) {
        return (num == 0 || num == 1) ? 1 : num * factorial(num - 1);
    }
}
