package org.example.neetcode150;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

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
        String[] strs =
//                {"", ""};
                {"eat", "tea", "tan", "ate", "nat", "bat"};

        /*This method fails when there are duplicates as i am using map with error of duplicate key*/
        /*{"c", "c"}*/
        log.info("The grouped anagrams are {}", groupAnagrams(strs));

        /*so trying with 2D Array*/
        log.info("The grouped anagrams are {}", groupAnagramsArrays(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        log.info("Input: {}", Arrays.toString(strs));
        Map<String, String> mappedData = Arrays.stream(strs).distinct().filter(word -> !word.isEmpty()).collect(Collectors.toMap(x -> x, x -> {
            String[] split = x.split("");
            Arrays.sort(split);
            return String.join("", split);
        }));
        log.info("Sort the each word and store it as a val {}", mappedData);
        List<List<String>> result = new ArrayList<>();
        Map<String, List<Map.Entry<String, String>>> collectByValue = mappedData.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue));
        log.info("groped by values to create List {}", collectByValue);
        collectByValue.values().forEach(x -> result.add(x.stream().map(Map.Entry::getKey).toList()));
        long emptyWords = Arrays.stream(strs).filter(String::isEmpty).count();
        ArrayList<String> emptyWordList = new ArrayList<>();
        for (int i = 0; i < emptyWords; i++)
            emptyWordList.add("");
        if (!emptyWordList.isEmpty())
            result.add(emptyWordList);
        return result;
    }

    public static List<List<String>> groupAnagramsArrays(String[] strs) {
        String[][] arrayWithIndex = new String[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            arrayWithIndex[i][0] = strs[i];
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            arrayWithIndex[i][1] = new String(charArray);
        }
        Map<String, List<String[]>> collect = Arrays.stream(arrayWithIndex).collect(Collectors.groupingBy(x -> x[1]));
        System.out.println("Result");
//        collect.values().stream().forEach(x -> Arrays.deepToString());
        return null;
    }
}
