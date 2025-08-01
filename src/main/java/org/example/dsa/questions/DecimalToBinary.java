package org.example.dsa.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
public class DecimalToBinary {
    /*
     * Decimal to Binary
     * 1.positive numbers
     * if the given number is a positive number
     *   keep on deciding the number and store the reminder in a string
     *   reverse this string to get the binary format
     *
     * 2.negative numbers
     *   if the number is negative we need to get the 2's complement
     *   considering the 8bit representation
     *   first convert the decimal to binary
     *   append zeros at the beginning if it string length is < 8
     *   invert all the bits
     *   add one to the binary result(binary sum)
     *   this will give you the binary of the negative number
     *
     * */

    public static void main(String[] args) {
        int number = 5;
        log.info("binary representation of {} is {}", number, decimalToBinaryForPositiveNumbers(number));
        log.info("binary representation of {} is {}", -1 * number, decimalToBinaryForNegativeNumbers(number));
    }

    private static String decimalToBinaryForPositiveNumbers(int number) {
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            binary.append(number % 2);
            number /= 2;
        }
        return binary.reverse().toString();
    }

    private static String decimalToBinaryForNegativeNumbers(int number) {
        String positiveBinary = decimalToBinaryForPositiveNumbers(number);
        log.info("binary positive{}", positiveBinary);
        String appendedZeros = String.format("%8s", positiveBinary).replace(" ", "0");
        log.info("after zero append {}", appendedZeros);
        String revertedBits = appendedZeros
                .chars()
                .mapToObj(x -> x == '0' ? "1" : "0")
                .collect(Collectors.joining());
        log.info("reverted bits {}", revertedBits);
        return (revertedBits.toCharArray()[revertedBits.length() - 1] == '1') ? revertedBits.substring(0, 7) + "0" : revertedBits.substring(0, 7) + "1";
    }
}
