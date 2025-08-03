package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class CreateTargetArrayInGivenOrder {
    /*
     * Q:https://leetcode.com/problems/create-target-array-in-the-given-order/
     * 1389. Create Target Array in the Given Order
        Easy
        Topics
        premium lock icon
        Companies
        Hint
        Given two arrays of integers nums and index. Your task is to create target array under the following rules:
        Initially target array is empty.
        From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
        Repeat the previous step until there are no elements to read in nums and index.
        Return the target array.
        It is guaranteed that the insertion operations will be valid.
        Example 1:
        Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
        Output: [0,4,1,3,2]
        Explanation:
        nums       index     target
        0            0        [0]
        1            1        [0,1]
        2            2        [0,1,2]
        3            2        [0,1,3,2]
        4            1        [0,4,1,3,2]
     * */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};
        log.info("Resulting target ordered array{}", createTargetArray(nums, index));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        /*
         * Approach
         * a. first create a resulting empty array with filled as -1
         * b. if for a given index result field == -1 then replace it with nums[i]
         * c. if result filed index[i] is already filled check next field is empty(-1)
         *    if yes move the existing element there and place the num[i] in index[i]
         * d. if none of the above case move till next blank space from the index[i]
         *     so it became empty now and replace that with nums[i]
         *
         *
         * */
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);

        for (int i = 0; i < length; i++) {
            if (result[index[i]] == -1)
                result[index[i]] = nums[i];
            else if (result[index[i] + 1] == -1) {
                result[index[i] + 1] = result[index[i]];
                result[index[i]] = nums[i];
            } else {
                int firstEmptyPlace = -1;
                for (int l = 0; l < length; l++) {
                    if (result[l] == -1) {
                        firstEmptyPlace = l;
                        break;
                    }
                }
                for (int k = firstEmptyPlace; k > index[i]; k--) {
                    result[k] = result[k - 1];
                }
                result[index[i]] = nums[i];
            }
        }

        /*
         * Second approach
         * use arrayList add method along with the index
         * */
        /*
        List<Integer> targetList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int valueToInsert = nums[i];
            int insertIndex = index[i];
            targetList.add(insertIndex, valueToInsert);
        }

        int[] targetArray = new int[targetList.size()];
        for (int i = 0; i < targetList.size(); i++) {
            targetArray[i] = targetList.get(i);
        }

        return targetArray;
        * */
        return result;
    }
}
