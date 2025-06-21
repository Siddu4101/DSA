package org.example.dsa.switchcases;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class SwitchStatements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        /*
         * 1. no duplicate keys are expected
         * 2. it is recommended to keep default at the end
         * 3. after a statement if u don't keep the break it will keep on executing the next statements
         *    if u r using normal
         * */

        /*normal switch case*/
        switch (x) {
            case 1:
                log.info("This is first");
                break;
            case 2:
                log.info("This is second");
                break;
            case 3:
                log.info("This is third");
                break;
            default:
                log.info("This is out of level it should be within 1-3");
        }

        /*enhanced switch statements*/
        switch (x) {
            case 1 -> log.info("This is first");
            case 2 -> log.info("This is second");
            case 3 -> log.info("This is third");
            default -> log.info("This is out of level it should be within 1-3");
        }
    }
}
