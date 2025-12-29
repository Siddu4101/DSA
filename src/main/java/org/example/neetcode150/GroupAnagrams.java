package org.example.neetcode150;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

@Slf4j
public class GroupAnagrams {
    /*
     * 4.https://leetcode.com/problems/group-anagrams/description/
     *49. Group Anagrams
        Given an array of strings strs, group the anagrams together. You can return the answer in any order.
        Example 1:
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Explanation:
        There is no string in strs that can be rearranged to form "bat".
        The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
        The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
     * */
    public static void main(String[] args) {
        String[] strs = {"", ""};
        //{"eat", "tea", "tan", "ate", "nat", "bat"};
        // input ==> ["",""] output ==> ["",""]
        log.info("The grouped anagrams are {}", groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        log.info("Input: {}", Arrays.toString(strs));
        Map<String, String> mappedData = Arrays.stream(strs).collect(Collectors.toMap(x -> x, x -> {
            String[] split = x.split("");
            Arrays.sort(split);
            return String.join("", split);
        }));
        log.info("Sort the each word and store it as a val {}", mappedData);
        List<List<String>> result = new ArrayList<>();
        Map<String, List<Map.Entry<String, String>>> collectByValue = mappedData.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue));
        log.info("groped by values to create List {}", collectByValue);
        collectByValue.values().forEach(x -> result.add(x.stream().map(Map.Entry::getKey).toList()));
        return result;
    }
}
