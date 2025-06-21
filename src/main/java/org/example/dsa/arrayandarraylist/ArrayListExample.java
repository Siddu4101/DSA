package org.example.dsa.arrayandarraylist;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Scanner;

@Slf4j
public class ArrayListExample {
    public static void main(String[] args) {
        /*
         * We use arraylist instead of array when we don't know the actual size of the array
         * this internally uses the dynamic array which increases the size of the array after the capacity
         * is full(default capacity is 10) once it is filled it will be increased by 1.5X
         * EX: right now we have 10 elements in the arrayList if u try to add 11th element it creates arraylist
         * of 15 elements and then do the copy to there and deleted the old one
         * you can pass the capacity if u want to change it from default val
         * you can have multidimensional arraylist too
         * ArrayList works only with Objects(non-preventives)
         * */

        /*declaration*/
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);

        log.info("array: {}", integers);


        /*multidimensional arrayList*/

        ArrayList<ArrayList<Integer>> integers2D = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            integers2D.add(new ArrayList<>());
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                integers2D.get(row).add(new Scanner(System.in).nextInt());
            }
        }

        log.info("array:{}", integers2D);
    }
}
