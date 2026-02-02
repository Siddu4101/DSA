package org.example.neetcode150;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ProductOfArrayExceptItSelf {

    /*
     * Q: https://leetcode.com/problems/product-of-array-except-self/description/
     *238. Product of Array Except Self
        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
        You must write an algorithm that runs in O(n) time and without using the division operation.
        Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

     * */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        log.info("The product array without extra space is {}", Arrays.toString(productExceptSelfViaWithoutExtraSpace(nums)));
        log.info("The product array via extra space for suffix prefix product array is {}", Arrays.toString(productExceptSelfViaExtraSuffixAndPrefixSpace(nums)));
        log.info("The product array via simplestWayOfPrefixAndPostFix {}", Arrays.toString(productExceptSelfViaSimplest(nums)));
    }

    private static int[] productExceptSelfViaSimplest(int[] nums) {
        int[] res = new int[nums.length];
        /*initialize each element of the res array*/
        Arrays.fill(res, 1);
        /*initialize pre and suf products */
        int prefixProduct = 1;
        int suffixProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] *= prefixProduct;/*stores prefix product*/
            prefixProduct *= nums[i];/*cal prefix product for each res[i]/ next iteration*/
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= suffixProduct;/*stores the result of the prefix and suffix product*/
            suffixProduct *= nums[i];/*cal suffix product for each res[i]/ previous iteration*/
        }
        return res;
    }

    private static int[] productExceptSelfViaWithoutExtraSpace(int[] nums) {
        /*form the prefix Product on the res array*/
        int[] res = new int[nums.length];
        res[0] = 1;/*set the prefix product for 0th index 1 as prefix not present*/
        for (int i = 1; i < res.length; i++)
            res[i] = nums[i - 1] * res[i - 1];

        int suffixProd = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = suffixProd * res[i];/*multiply suffix product with existing prefix prod*/
            suffixProd = suffixProd * nums[i];/*cal suffix product for next iteration*/
        }

        return res;
    }

    public static int[] productExceptSelfViaExtraSuffixAndPrefixSpace(int[] nums) {
        /*Via extra space for prefix and suffix product*/
        int[] prefixProduct = new int[nums.length];
        /*first element will be 1 as nu element before 0th index*/
        prefixProduct[0] = 1;
        for (int i = 1; i < prefixProduct.length; i++)
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        log.info("Prefix product {}", Arrays.toString(prefixProduct));

        /*suffixProduct*/
        int[] suffixProduct = new int[nums.length];
        suffixProduct[suffixProduct.length - 1] = 1;/*no suffix after last element so set to 1*/
        for (int i = suffixProduct.length - 2; i >= 0; i--)
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        log.info("Suffix product {}", Arrays.toString(suffixProduct));

        /*multiply both prefix and suffix array to get the final array*/
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[i] = prefixProduct[i] * suffixProduct[i];

        return res;
    }


}
