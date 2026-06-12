package org.example.neetcode75.arraysAndHashing.groupAnagrams4;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class GroupAnagrams {

/*
* Q: https://leetcode.com/problems/group-anagrams/description/
* 49. Group Anagrams
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
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        log.info("Via brut force sorted arrays: {}", groupAnagramsViaBrutForceSortedArray(strs.clone()));
        log.info("Via sorted individual strings: {}", groupAnagramsViaSortedString(strs));
        log.info("Via hashmap: {}", groupAnagramsViaHashMap(strs));
        log.info("Via hashmap with alphabet array as a key: {}", groupAnagramsViaHashMapKeyAsAlphabetArray(strs));
    }

    /*Approach:01
     * T: O(n2) or O(n2 * klognk)
     * S: O(n)
     * */
    private static List<List<String>> groupAnagramsViaBrutForceSortedArray(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (Objects.equals(strs[i], "#Sid#"))
                continue;
            ArrayList<String> subAnagrams = new ArrayList<>();
            char[] sArr = strs[i].toCharArray();
            subAnagrams.add(strs[i]);
            Arrays.sort(sArr);
            for (int j = i + 1; j < strs.length; j++) {
                char[] tArr = strs[j].toCharArray();
                Arrays.sort(tArr);
                if (Arrays.equals(sArr, tArr)) {
                    subAnagrams.add(strs[j]);
                    strs[j] = "#Sid#";
                }
            }
            if (!subAnagrams.isEmpty())
                anagrams.add(subAnagrams);
        }
        return anagrams;
    }


    /*Approach: 02
     * T: O(nk lognk)
     * S: O(nk) => k is longest length of a string
     * */

    private static List<List<String>> groupAnagramsViaSortedString(String[] strs) {
        String[][] strings = new String[strs.length][2];

        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            strings[i][0] = String.valueOf(charArray);
            strings[i][1] = strs[i];
        }
        Arrays.sort(strings, (a, b) -> a[0].compareTo(b[0]));

        List<List<String>> anagrams = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            ArrayList<String> subAnagrams = new ArrayList<>();
            subAnagrams.add(strings[i][1]);
            while (i < strings.length - 1 && strings[i][0].equals(strings[i + 1][0])) {
                subAnagrams.add(strings[i + 1][1]);
                i++;
            }
            anagrams.add(subAnagrams);
        }
        return anagrams;
    }

    /*
     * Approach:03
     * T: O(n klogk)
     * S: O(nk)
     * */
    private static List<List<String>> groupAnagramsViaHashMap(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            anagramMap.putIfAbsent(s, new ArrayList<>());
            anagramMap.get(s).add(str);
        }

        return anagramMap.values().stream().toList();
    }


    /*
     * Approach: 04
     * T: O(nk)
     * S: O(nk)
     * */
    private static List<List<String>> groupAnagramsViaHashMapKeyAsAlphabetArray(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[26];
            char[] charArray = str.toCharArray();
            for (char c : charArray)
                chars[c - 'a']++;

            anagramMap.putIfAbsent(Arrays.toString(chars), new ArrayList<>());
            anagramMap.get(Arrays.toString(chars)).add(str);
        }

        return anagramMap.values().stream().toList();
    }
}
