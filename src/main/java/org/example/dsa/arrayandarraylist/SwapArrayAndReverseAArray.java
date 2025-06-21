package org.example.dsa.arrayandarraylist;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class SwapArrayAndReverseAArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 1, 6, 2};
        Scanner scanner = new Scanner(System.in);

        /*swap 2 position*/
        int star = scanner.nextInt();
        int end = scanner.nextInt();

        log.info("before 2 position swap:{}", arr);

        swap(arr, star, end);

        log.info("After 2 position swap:{}", arr);

        /*Reverse the array*/
        reverse(arr);
    }

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        log.info("Before reversing:{}", arr);

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }

        log.info("After reversing: {}", arr);
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
