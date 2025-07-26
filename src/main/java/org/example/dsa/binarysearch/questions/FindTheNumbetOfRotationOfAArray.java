package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindTheNumbetOfRotationOfAArray {
    /*
     * https://www.geeksforgeeks.org/dsa/find-rotation-count-rotated-sorted-array/
     * Input: arr[] = {15, 18, 2, 3, 6, 12}
     * Output: 2
     * Explanation: Initial array must be {2, 3, 6, 12, 15, 18}.
     * We get the given array after rotating the initial array twice.

     * Input: arr[] = {7, 9, 11, 12, 5}
     * Output: 4

     * Input: arr[] = {7, 9, 11, 12, 15};
     * Output: 0
     *
     * */

    /*
     * Approach:
     * just find the pivot index + 1
     * */
    public static void main(String[] args) {
        int[] arr = {7, 9, 11, 12, 5};
        log.info("rotations {}", findTheNumberOfRotations(arr) + 1);
    }

    private static int findTheNumberOfRotations(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid != arr.length - 1 && arr[mid] > arr[mid + 1])
                return mid;
            else if (mid != 0 && arr[mid] < arr[mid - 1])
                return mid - 1;
            else if (arr[start] > arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}

class Test {
    static {
        System.out.println("This is inside static");
    }
}

class TestTest {
    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();
    }
}

class TrialClass {

    static class TrialInnerClass {

    }

    class TrialNonStaicClass {

    }
}

class newTrial {
    public static void main(String[] args) {
        /*outerclass instance*/
        TrialClass trialClass = new TrialClass();
        /*Inner class non static instance*/
        TrialClass.TrialNonStaicClass trialNonStaicClass1 = new TrialClass().new TrialNonStaicClass();
        TrialClass.TrialInnerClass trialInnerClass = new TrialClass.TrialInnerClass();
    }
}