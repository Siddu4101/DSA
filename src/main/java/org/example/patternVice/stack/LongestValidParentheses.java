package org.example.patternVice.stack;

import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses {
    /*
     * Q:https://leetcode.com/problems/longest-valid-parentheses/description/
     *32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0
     *
     * */

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println("The longest valid paranthesis length is " + longestValidParenthesess(s));
        System.out.println("The longest valid paranthesis length is " + longestValidParentheses(s));
    }

    /*Approach 1 failure*/
    private static int longestValidParentheses(String s) {
        int openBraces = 0;
        int validInOneSection = 0;
        int longestValidParenthesis = 0;

        for (char ch : s.toCharArray()) {
            if (openBraces == 0 && ch == ')')
                continue;
            else if (ch == '(')
                openBraces++;
            else {
                openBraces--;
                validInOneSection += 2;
                if (openBraces == 0) {
                    longestValidParenthesis = Math.max(validInOneSection, longestValidParenthesis);
                    validInOneSection = 0;
                }
            }
        }

        return longestValidParenthesis;
    }


    /*Approach 2 failure*/
    public static int longestValidParenthesess(String s) {
        Stack<Character> stack = new Stack<>();
        int validParenthesesCount = 0;
        int maxLenght = 0;
        for (char ch : s.toCharArray()) { //()(()
            if (ch == ')' && stack.isEmpty()) {
                maxLenght = Math.max(validParenthesesCount, maxLenght);
                validParenthesesCount = 0;
            } else if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
                validParenthesesCount += 2;
            }
        }

        return (stack.isEmpty()) ? Math.max(validParenthesesCount, maxLenght) : validParenthesesCount;
    }
}
