package org.example.dsa.switchcases;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

import static org.example.dsa.switchcases.SwitchStatements.Levels.*;

@Slf4j
public class SwitchStatements {
    private static final String FIRST_MSG = "This is first";
    private static final String SECOND_MSG = "This is second";
    private static final String THIRD_MSG = "This is third";
    private static final String OUT_OF_LEVEL_MSG = "This is out of level it should be within 1-3";

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
                log.info(FIRST_MSG);
                break;
            case 2:
                log.info(SECOND_MSG);
                break;
            case 3:
                log.info(THIRD_MSG);
                break;
            default:
                log.info(OUT_OF_LEVEL_MSG);
        }

        /*enhanced switch statements*/
        switch (x) {
            case 1 -> log.info(FIRST_MSG);
            case 2 -> log.info(SECOND_MSG);
            case 3 -> log.info(THIRD_MSG);
            default -> log.info(OUT_OF_LEVEL_MSG);
        }

        /*Switch with enum*/
        Levels level = Levels.valueOf(scanner.next());
        switch (level) {
            case ONE -> log.info(ONE.value);
            case TWO -> log.info(TWO.value);
            case THREE -> log.info(THREE.value);
            default -> log.info(OUT_OF_LEVEL_MSG);
        }
    }

    enum Levels {
        ONE(FIRST_MSG),
        TWO(SECOND_MSG),
        THREE(THIRD_MSG);

        final String value;

        Levels(String value) {
            this.value = value;
        }
    }
}
