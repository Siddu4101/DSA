package org.example.dsaUdemy.sortAlgorithms.selection;

import lombok.extern.slf4j.Slf4j;

import static org.example.dsaUdemy.sortAlgorithms.SortHelper.printArray;
import static org.example.dsaUdemy.sortAlgorithms.SortHelper.swap;

@Slf4j
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {13, 2, -34, 6, 10};
        selectionSort(nums.clone());
        selectionSortReverseTraverse(nums.clone());
    }


    /*
     * T: O(n2)
     * S: O(1)
     * Stable: False
     * */

    /**
     * Selection Sort - Forward Traverse (left to right)
     * <p>
     * Steps:
     * 1. Outer loop: track number of sorted elements (from 0 to end)
     * 2. Inner loop: scan unsorted portion (0 to length - sortedNoOfElements)
     * 3. Find index of maximum element in unsorted portion
     * 4. Swap max element with last position of unsorted portion
     * 5. After each pass, unsorted boundary shrinks by 1
     * 6. Continue until all elements sorted
     */
    private static void selectionSort(int[] nums) {
        printArray("Before selection sort ", nums);
        for (int sortedNoOfElements = 0; sortedNoOfElements < nums.length; sortedNoOfElements++) { /*each pass to select max element in this pass*/
            int maxArrayIndex = 0; /*next max element position tracker*/
            for (int j = 0; j < nums.length - sortedNoOfElements; j++) { /*traverse till sorted array and find the max element position*/
                if (nums[j] > nums[maxArrayIndex])
                    maxArrayIndex = j;
            }

            /*swap the next max element with next insertable sorted array position*/
            int nextInsertableSortedArrayPosition = nums.length - 1 - sortedNoOfElements;
            swap(nums, nextInsertableSortedArrayPosition, maxArrayIndex);
        }
        printArray("After selection sort ", nums);
    }


    /**
     * Selection Sort - Reverse Traverse (right to left)
     * <p>
     * Steps:
     * 1. Outer loop: start from last index, move backwards (right to left)
     * 2. Inner loop: scan from start (0) to current position (sortedArrayIndex)
     * 3. Find index of maximum element in this range
     * 4. Swap max element with current position (sortedArrayIndex)
     * 5. After each pass, sorted boundary moves left by 1
     * 6. Continue until only first element remains
     * <p>
     * Same logic as forward traverse, but traverses from right to left
     */
    private static void selectionSortReverseTraverse(int[] nums) {
        printArray("Before selection sort traversing in reverse order", nums);
        for (int sortedArrayIndex = nums.length - 1; sortedArrayIndex > 0; sortedArrayIndex--) {
            int maxElementIndex = 0;
            for (int unsortedArrayIndex = 0; unsortedArrayIndex <= sortedArrayIndex; unsortedArrayIndex++) {
                if (nums[unsortedArrayIndex] > nums[maxElementIndex])
                    maxElementIndex = unsortedArrayIndex;
            }
            swap(nums, sortedArrayIndex, maxElementIndex);
        }
        printArray("After selection sort traversing in reverse order", nums);
    }

}
