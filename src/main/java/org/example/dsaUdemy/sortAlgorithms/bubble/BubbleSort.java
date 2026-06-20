package org.example.dsaUdemy.sortAlgorithms.bubble;

import lombok.extern.slf4j.Slf4j;

import static org.example.dsaUdemy.sortAlgorithms.SortHelper.printArray;
import static org.example.dsaUdemy.sortAlgorithms.SortHelper.swap;

@Slf4j
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {12, 4, -45, 95, 10, 16};
        bubbleSort(nums.clone());
        bubbleSortViaFor(nums.clone());
        bubbleSortViaForOptimized(nums.clone());
    }

    /*
     * Steps: (ASC sort)
     *   1. consider whole array as a unsorted
     *   2. start from 0 and go till end compare the i element with i + 1 if i > i + 1 element swap it and continue but increment i
     *   3. after first pass reduce the length of next traverse by 1 as the highest element have moved to the last and continue
     *      this till length become 0
     * */

    /*
     * T: O(n2)
     * S: O(1)
     * Stable: True
     * */

    /**
     * Bubble Sort using while loop
     * <p>
     * Steps:
     * 1. Compare adjacent elements from start to unsorted end
     * 2. Swap if left > right (bubble larger element to end)
     * 3. After each pass, shrink unsorted boundary by 1
     * 4. Repeat until unsorted boundary reaches 0
     */
    private static void bubbleSort(int[] nums) {
        printArray("Before bubbleSort", nums);
        int unsortedArrayLastIndex = nums.length - 1;
        int i = 0;
        while (unsortedArrayLastIndex > 0) {
            if (nums[i] > nums[i + 1])
                swap(nums, i, i + 1);
            if (i == unsortedArrayLastIndex - 1) { /*on each pass when u reach end reduce the unsorted length and reset i for next pass*/
                unsortedArrayLastIndex--; /*everytime when a max bubble reaches end decrease this*/
                i = 0;/*reset the start*/
            } else {
                i++;
            }
        }

        printArray("After bubbleSort", nums);
    }


    /**
     * Bubble Sort using nested for loops
     * <p>
     * Steps:
     * 1. Outer loop: track number of sorted elements
     * 2. Inner loop: scan unsorted portion, compare adjacent pairs
     * 3. Swap if left > right (bubble max to the end)
     * 4. After each outer loop iteration, unsorted portion shrinks by 1
     * 5. Continue until all elements are sorted
     */
    private static void bubbleSortViaFor(int[] nums) {

        printArray("Before sort via for", nums);
        /*Alternative with 2 nested for*/
        for (int numberOfSortedElements = 0; numberOfSortedElements < nums.length; numberOfSortedElements++) {

            for (int j = 0; j < nums.length - 1 - numberOfSortedElements; j++) {/* -numberOfSortedElements do reduces the last element for each pass is it pops max element at the end*/
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }

        }
        printArray("After sort via for", nums);
    }


    /**
     * Bubble Sort with early exit optimization
     * <p>
     * Steps:
     * 1. Outer loop: track number of sorted elements
     * 2. Initialize swapped flag to false before inner loop
     * 3. Inner loop: scan unsorted portion, compare adjacent pairs
     * 4. Swap if left > right, set swapped = true
     * 5. After inner loop: if no swaps occurred, array is sorted → exit early
     * 6. Otherwise, continue with next pass
     * <p>
     * Time: O(n) best case (already sorted), O(n²) worst case
     */
    private static void bubbleSortViaForOptimized(int[] nums) {
        printArray("Before sort via for optimized", nums);
        /*Alternative with 2 nested for*/
        for (int numberOfSortedElements = 0; numberOfSortedElements < nums.length; numberOfSortedElements++) {
            boolean swapped = false;
            for (int j = 0; j < nums.length - 1 - numberOfSortedElements; j++) {/* -numberOfSortedElements do reduces the last element for each pass is it pops max element at the end*/
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                printArray("After sort via for optimized", nums);
                return; /*if in any pass there is no swap then just come out as this is already sorted*/
            }
        }
    }

}
