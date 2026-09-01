package org.example.patternVice.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Slf4j
public class ValidParenthesis {
    /*
     * Q:https://leetcode.com/problems/valid-parentheses/
     *20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

     * */
    public static void main(String[] args) {
        String s = "()[]{}";
        log.info("The given parenthesis {} is valid = {}", s, isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenthesisMatches = Map.of(')', '(', '}', '{', ']', '[');

        for (Character ch : s.toCharArray()) {
            if (parenthesisMatches.containsValue(ch))
                stack.push(ch);
            else {
                Character recentOpenedBrace = stack.pop();
                if (!ch.equals(recentOpenedBrace))
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
