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
        String s = "()[]";
        log.info("The given parenthesis {} is valid = {}", s, isValid(s));
        log.info("The given parenthesis {} is valid better approach = {}", s, isValidBetterWay(s));
    }

    /*
     * Approach:
     * 1. if it is valid first the brace count should be even, push open brace to stack
     * 2. if it is a closing check stack is empty if it is then it is extra closing so return false
     * 3. else pop the recent opened brace and match with closing incoming brace and match if not matches return false
     * 4. at the end stack should be empty if we have valid set of parenthesis
     * */

    /*
     * T: O(n)
     * S: O(n)
     * */
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenthesisMatches = Map.of('(', ')', '{', '}', '[', ']');

        for (Character ch : s.toCharArray()) {
            if (parenthesisMatches.containsKey(ch)) /*if it is open brace just push it to stack*/
                stack.push(ch);
            else {
                if (stack.isEmpty()) /*if there is no opening brace and a new incoming closing brace then it is invalid*/
                    return false;
                Character recentOpenedBrace = stack.pop(); /*if there is open brace already present check with incoming closing for match*/
                if (!ch.equals(parenthesisMatches.get(recentOpenedBrace)))
                    return false;
            }
        }
        return stack.isEmpty(); /*if the braces are valid stack will be empty at the end*/
    }

    public static boolean isValidBetterWay(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) { /*if incoming is a open brace push it's closing version*/
            if (ch == '[')
                stack.push(']');

            else if (ch == '{')
                stack.push('}');

            else if (ch == '(')
                stack.push(')');

            else if (stack.isEmpty() || ch != stack.pop()) /* when it is closing brace incoming check stack is empty or stack top element not equal to incoming closing match then return false*/
                return false;
        }
        return stack.isEmpty(); /*if the braces are valid stack will be empty at the end*/
    }


}
