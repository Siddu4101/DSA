package org.example.dsa.loopsandcondition;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequencyOfTheDigitInaGivenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = scanner.nextLong();
        int digit = scanner.nextInt();
        firstWayToGetTheFrequencyOfADigitInANumber(number, digit);
        secondWayToGetTheFrequencyOfADigitInANumber(number, digit);

    }

    static void firstWayToGetTheFrequencyOfADigitInANumber(long number, int digit) {
        Map<Integer, Long> collect = Arrays.stream(String.valueOf(number).split("")).map(Integer::valueOf).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        Optional<Long> first = collect.entrySet().stream().filter(x -> x.getKey() == digit).map(Map.Entry::getValue).findFirst();
        System.out.println("frequency of the digit " + digit + " in the given number " + number + " is " + first.orElse(0L));
    }

    static void secondWayToGetTheFrequencyOfADigitInANumber(long number, int digit) {
        int count = 0;
        long numForLog = number;
        while (number > 0) {
            long rem = number % 10;
            if (rem == digit)
                count++;
            number = number / 10;
        }
        System.out.println("frequency of the digit " + digit + " in the given number " + numForLog + " is " + count);
    }
}
