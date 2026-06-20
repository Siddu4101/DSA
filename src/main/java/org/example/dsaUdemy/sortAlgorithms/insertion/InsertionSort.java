package org.example.dsaUdemy.sortAlgorithms.insertion;

import lombok.extern.slf4j.Slf4j;

import static org.example.dsaUdemy.sortAlgorithms.SortHelper.printArray;

@Slf4j
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {13, 2, -34, 6, 10};
        insertionSort(nums);
    }


    /**
     * Insertion Sort
     * <p>
     * Steps:
     * 1. Start from second element (index 1), assume first element is sorted
     * 2. For each element, store it in elementToBeInserted
     * 3. Inner loop: traverse sorted portion backwards from current position
     * 4. While sorted element > elementToBeInserted, shift sorted element right
     * 5. Insert elementToBeInserted at correct position
     * 6. After each outer loop iteration, sorted portion grows by 1
     * 7. Continue until all elements are inserted
     * <p>
     * Similar to sorting cards in hand - pick each card and insert at correct position
     */
    /*
     * T: O(n2)
     * S: O(1)
     * Stable: True
     * */
    private static void insertionSort(int[] nums) {
        printArray("Before insertion sort", nums);
        if (nums.length < 2)
            return;

        for (int nextElementToInsert = 1; nextElementToInsert < nums.length; nextElementToInsert++) {
            int elementToBeInserted = nums[nextElementToInsert];
            int sortedArrayIndexEnd;
            for (sortedArrayIndexEnd = nextElementToInsert - 1; sortedArrayIndexEnd >= 0 && nums[sortedArrayIndexEnd] > elementToBeInserted; sortedArrayIndexEnd--) {
                nums[sortedArrayIndexEnd + 1] = nums[sortedArrayIndexEnd];
            }
            nums[sortedArrayIndexEnd + 1] = elementToBeInserted;
        }
        printArray("After insertion sort", nums);
    }
}
