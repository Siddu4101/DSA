package org.example.patternVice.validParentheses;

/* Q:   https://leetcode.com/problems/valid-parentheses/description/

20. Valid Parentheses
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
*/

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Slf4j
public class ValidParentheses {
    public static void main(String[] args) {
        String input = "{}{{}}[]";
        log.info("valid parentheses via bruteforce {}", isValidParenthesesViaBruteForce(input));
        log.info("valid parentheses via stack {}", isValidParenthesisByStack(input));
    }

    /*
     * Approach:1
     * a. remove the smallest matching like () or {} or [] bcz at the end it will match even u have nested things
     * b. if the resulting string is empty it is valid else not
     *
     *
     * T: O(n2)  ==> O(n) * O(n) ==> contains * replace
     * S: O(n)  ==> O(n) creates a new string everytime for replace
     * */
    public static boolean isValidParenthesesViaBruteForce(String s) {
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) { /* contains takes O(n)*/
            s = s.replace("{}", ""); /*replace does another scan O(n) and creates new string everytime*/
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

    /*
     * Approach 02
     * a. if parentheses is open push to stack
     * b. if it is close and no open entry in stac return false
     * c. if close and stack is not empty pop the top element and match it with current close bracket
     *    if matches go ahead else return false
     * d. at the end if the stack is empty  return true else false
     *
     *
     *
     * T: O(n)
     * S: O(n)
     * */

    public static boolean isValidParenthesisByStack(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');

        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (bracketPairs.containsValue(ch))
                stack.push(ch);
            else {
                if (!stack.isEmpty()) {
                    Character topElement = stack.pop();
                    if (!topElement.equals(bracketPairs.get(ch)))
                        return false;
                } else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}