package org.example.patternVice.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ValidTriangleNumber {

    /*
     * Q: https://leetcode.com/problems/valid-triangle-number/description/
611. Valid Triangle Number
Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Example 2:
Input: nums = [4,2,3,4]
Output: 4
     * */

    public static void main(String[] args) {
        int nums[] = {2, 2, 3, 4};
        log.info("The total valid triplet for valid triangle is {}", triangleNumber(nums));
    }

    /*
     * Approach:
     * 1. sort nums
     * 2. start from largest element a from last and b = a - 1 and c = 0
     * 3. we know a is the largest so a+b > c and a+c > b always true so need to check only b+c > a
     * 4. if b + c > a then take all the pairs between c and b as next elements of c is already  greater than c and these are wrt b so after this decrement b
     * 5. if b + c <= a then increment c to get the valid pair
     * */

    /*
     * T: O(n2)
     * S: O(1)
     * */
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int b, c, count = 0;
        for (int a = nums.length - 1; a > 1; a--) {
            b = a - 1;
            c = 0;

            while (c < b) {
                if (nums[b] + nums[c] > nums[a]) {/*we need only those which are c+b > a bcz we know a is the largest so a+b > c and a+c > b  is always true only need to check the b+c>a*/
                    count += b - c; /*consider all the pair between b and c  bcz v know a > b > c   if current c+b > a  then coming things after current c will be > c so consider all of them*/
                    b--; /*v r decreasing b as we have counted all the possible value wrt b ex: first iteration 4,3 and 4,2 */
                } else {
                    c++; /*when we have lesser some move c*/
                }
            }
        }
        return count;
    }
}
