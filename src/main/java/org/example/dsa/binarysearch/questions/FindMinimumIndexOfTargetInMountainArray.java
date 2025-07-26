package org.example.dsa.binarysearch.questions;

import lombok.extern.slf4j.Slf4j;

interface MountainArray {
    public int get(int index);

    public int length();
}

@Slf4j
public class FindMinimumIndexOfTargetInMountainArray {
    /*
     *
     * 1095. Find in Mountain Array
     * Example 1:

     * Input: mountainArr = [1,2,3,4,5,3,1], target = 3
     * Output: 2
     * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
     * Example 2:

     * Input: mountainArr = [0,1,2,4,2,1], target = 3
     * Output: -1
     * Explanation: 3 does not exist in the array, so we return -1.
     * */

    /*
     * Solution Approach:
     * 1. find the peak element index
     * 2. try to find the target element from 0-peakElementIndex(in Asc array)
     * 3. if not found search element in the peakElementIndex-end (in Desc array)
     * */
    public static void main(String[] args) {
        log.info("OutPut:{}", findInMountainArray(3, new MountainArrayImpl()));
    }

    public static int findInMountainArray(int target, MountainArrayImpl mountainArr) {
        /*Find the peak*/
        int peakElementIndex = peakElementInMountainArray(mountainArr);

        /*Search in Asc Array*/
        int outPut = searchInAscArray(mountainArr, peakElementIndex, target);
        /*Search In Desc Array*/
        if (outPut == -1)
            outPut = searchInDescArray(mountainArr, peakElementIndex, target);

        return outPut;
    }

    static int peakElementInMountainArray(MountainArrayImpl mountainArray) {
        int start = 0;
        int end = mountainArray.length() - 1;
        int mid;
        while (start != end) {
            mid = start + (end - start) / 2;
            if (mountainArray.get(mid) < mountainArray.get(mid + 1))
                start = mid + 1;
            else if (mountainArray.get(mid) > mountainArray.get(mid + 1))
                end = mid;
        }
        return start;
    }

    static int searchInAscArray(MountainArrayImpl mountainArray, int peakElementIndex, int target) {
        int start = 0;
        int end = peakElementIndex;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mountainArray.get(mid) == target)
                return mid;
            else if (mountainArray.get(mid) < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    static int searchInDescArray(MountainArrayImpl mountainArray, int peakElementIndex, int target) {
        int start = peakElementIndex;
        int end = mountainArray.length() - 1;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mountainArray.get(mid) == target)
                return mid;
            else if (mountainArray.get(mid) < target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}

class MountainArrayImpl implements MountainArray {
    int[] arr = {1, 2, 3, 5, 3};//{1, 5, 2};// {1, 2, 3, 4, 5, 3, 1};//{0, 1, 2, 4, 2, 1};//{1, 2, 3, 4, 5, 3, 1};

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }

}
