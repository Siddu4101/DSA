package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class FindFirstAndLastPositionOfTargetInArray {

    /*
     * 34. Find First and Last Position of Element in Sorted Array
     * Example 1:

     *   Input: nums = [5,7,7,8,8,10], target = 8
     *   Output: [3,4]
     *   Example 2:

     *   Input: nums = [5,7,7,8,8,10], target = 6
     *   Output: [-1,-1]
     *   Example 3:

     *   Input: nums = [], target = 0
     *   Output: [-1,-1]
     *
     * */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 9};
        int target = 3;
        /*First way*/
        /*
         * here i am finding any occurrence of a given target and
         * then do a sequence scan to right and left to find the start and end pos
         * some time it may go to time complexity of N if u need log(N) follow 2nd approach
         * */
        log.info("the result is {}", findTheFirstAndLastPositionOfTarget(nums, target));

        /*Second and better way*/
        /*
         * here we will find any occurrence of a given target and then apply the BS again
         * to the right to find the lastPos and
         * apply BS again to left array to find the firstPos
         * */

        int[] output = {-1, -1};
        log.info("getting the first occurrence of the target in given array");
        output[0] = findTheFirstAndLastPositionOfTargetBetterWay(nums, target, true);
        if (output[0] != -1) {
            log.info("getting the last occurrence of the target in given array");
            output[1] = findTheFirstAndLastPositionOfTargetBetterWay(nums, target, false);
        }
        log.info("OutPut:{}", Arrays.toString(output));
    }


    private static int[] findTheFirstAndLastPositionOfTarget(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int startPos = -1;
        int endPos = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                startPos = endPos = mid;
                while (arr[startPos] == arr[mid]) {
                    if (startPos != 0 && arr[startPos - 1] == arr[mid])
                        startPos -= 1;
                    else
                        break;
                }
                while (arr[endPos] == arr[mid]) {
                    if (endPos != arr.length - 1 && arr[endPos + 1] == arr[mid])
                        endPos += 1;
                    else
                        break;
                }
                return new int[]{startPos, endPos};
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return new int[]{startPos, endPos};
    }

    private static int findTheFirstAndLastPositionOfTargetBetterWay(int[] arr, int target, boolean findFirstPos) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int ans = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                if (findFirstPos)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return ans;
    }

}
