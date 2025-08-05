package org.example.dsa.arrayandarraylist.questions;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CountItemsMatchingRule {
    /*
     * Q:https://leetcode.com/problems/count-items-matching-a-rule/
     *1773. Count Items Matching a Rule
        Easy
        Topics
        premium lock icon
        Companies
        Hint
        You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

        The ith item is said to match the rule if one of the following is true:

        ruleKey == "type" and ruleValue == typei.
        ruleKey == "color" and ruleValue == colori.
        ruleKey == "name" and ruleValue == namei.
        Return the number of items that match the given rule.



        Example 1:

        Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
        Output: 1
        Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
     *
     * */
    public static void main(String[] args) {
        List<List<String>> items = List.of(List.of("phone", "blue", "pixel"), List.of("computer", "silver", "lenovo"), List.of("phone", "gold", "iphone"));
        String ruleKey = "color";
        String ruleValue = "silver";
        log.info("number of matching rules count {}", countMatches(items, ruleKey, ruleValue));
        log.info("number of matching rules count {}", countMatches2(items, ruleKey, ruleValue));

    }


    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            if ((ruleKey.equals("type") && item.get(0).equals(ruleValue)) ||
                    (ruleKey.equals("color") && item.get(1).equals(ruleValue)) ||
                    (ruleKey.equals("name") && item.get(2).equals(ruleValue)))
                count++;
        }
        return count;
    }

    public static int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            default -> 2;
        };

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue))
                count++;
        }
        return count;
    }
}
