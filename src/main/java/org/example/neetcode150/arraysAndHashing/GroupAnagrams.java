package org.example.neetcode150.arraysAndHashing;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

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
//                {"c", "c"};
//                {"", ""};
                {"eat", "tea", "tan", "ate", "nat", "bat",};

        /*This method fails when there are duplicates as i am using map with error of duplicate key*/
        /*{"c", "c"}*/
        log.info("The grouped anagrams are from Map {}", groupAnagrams(strs));

        /*so trying with 2D Array*/
        log.info("The grouped anagrams are from array {}", groupAnagramsArrays(strs));

        /*via hashmap internal functions*/
        log.info("The grouped anagrams are form map with computeIfAbsent {}", groupAnagramsMapComputeIfAbsent(strs));
    }

    /*simplest and best way*/
    private static List<List<String>> groupAnagramsMapComputeIfAbsent(String[] strs) {
        HashMap<String, List<String>> subList = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            /*there are 2 ways u can put the value (in both case if we set or return the lambda as null it removes the entry*/
            /*1. computIfAbsent : check for the key if already present returns the value if not creates the entry with lambda(2nd arg as value) and returns value*/
            subList.computeIfAbsent(new String(charArray), k -> new ArrayList<>()).add(s);
            /*2. compute: which runs the lambda always and if the key not present it creates and returns the value if already exist it gets and helps for the update or delete*/
//            subList.compute(new String(charArray), (k, v) -> v == null ? new ArrayList<>() : v).add(s);
        }
        return new ArrayList<>(subList.values());
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

        List<List<String>> result = new ArrayList<>();
        collect.values().forEach(x -> {
            ArrayList<String> subList = new ArrayList<>();
            for (String[] strings : x)
                subList.add(strings[0]);
            result.add(subList);
        });
        return result;
    }


    public static List<List<String>> groupAnagramsWithHasMapMethod(String[] strs) {
        HashMap<String, List<String>> anagramCountMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);
            /*there are 2 ways u can put the value (in both case if we set or return the lambda as null it removes the entry*/
            /*1. computIfAbsent : check for the key if already present returns the value if not creates the entry with lambda(2nd arg as value) and returns value*/
            anagramCountMap.computeIfAbsent(sortedKey, key -> new ArrayList<>()).add(str);

            /*2. compute: which runs the lambda always and if the key not present it creates and returns the value if already exist it gets and helps for the update or delete*/
//            anagramCountMap.compute(sortedKey, (k,v)-> v == null ? new ArrayList<String>() : v).add(str);
        }
        return anagramCountMap.values().stream().toList();
    }
}
