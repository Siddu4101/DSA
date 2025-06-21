package org.example.dsa.arrayandarraylist;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

@Slf4j
public class ArraysExample {
    public static void main(String[] args) {

        /*
         * Arrays are used to store same datatype multiple values in a single a var
         * in java we cannot give guarantee of continuous memory as it managed by jvm and heap doesn't guarantee this feature
         * */

        /*declaration*/

        int[] arr = new int[4]; /*array of 4 elements*/

        /*initialization*/
        /*1. via index*/
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;

        log.info(Arrays.toString(arr));

        /*2. initialization at the time of declaration*/

        int[] arr2 = {1, 2, 3, 4};
        log.info(Arrays.toString(arr2));


        /*Multi Dimensional Arrays */

        int[][] arr2d = new int[3][3]; /* column size is not mandatory*/

        for (int row = 0; row < arr2d.length; row++) {
            for (int col = 0; col < arr2d.length; col++) {
                arr2d[row][col] = new Scanner(System.in).nextInt();
            }
        }

        /*print the array*/
        for (int row = 0; row < arr2d.length; row++) {
            for (int col = 0; col < arr2d[row].length; col++) {
                System.out.print(arr2d[row][col] + " ");
            }
            System.out.println();
        }

        /*using enhanced for and array utils*/
        for (int[] ints : arr2d) {
            log.info(Arrays.toString(ints));
        }
    }
}
