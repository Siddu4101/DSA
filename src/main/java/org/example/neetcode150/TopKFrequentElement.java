package org.example.neetcode150;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class TopKFrequentElement {
    /*
     * Q: https://leetcode.com/problems/top-k-frequent-elements/description/
     *347. Top K Frequent Elements
        Medium
        Topics
        premium lock icon
        Companies
        Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

        Example 1:
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]

        Example 2:
        Input: nums = [1], k = 1
        Output: [1]
     * */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        log.info("The top {} frequent numbers are {}", k, Arrays.toString(topKFrequent(nums, k)));
        log.info("Top K elements via heap {}", Arrays.toString(topKUsingHeap(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).mapToInt(Map.Entry::getKey).toArray();
    }

    public static int[] topKUsingHeap(int[] nums, int k) {
        /*get the frequency map*/
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        /*create priority queue which will hold val, key array val as identity to create min heap and will have max k entry to return result*/
        PriorityQueue<int[]> topKElements = new PriorityQueue<>((a, b) -> a[0] - b[0]);/*Min heap containing array uses first element for maintain heap structure*/

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            topKElements.add(new int[]{entry.getValue(), entry.getKey()});/*based on value we are creating the heap so max frequency will go down */
            if (topKElements.size() > k) /*to maintain max k elements in heap*/
                topKElements.poll(); /*and > k we will poll which removes the smaller once*/
        }
        /*return the top k elements key from the heap*/
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = topKElements.poll()[1];
        return res;
    }
}
