package org.example.patternVice.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

@Slf4j
public class DecodeString {
    /*
     * Q: https://leetcode.com/problems/decode-string/description/
     * 394. Decode String
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
     * */
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        log.info("The decoded string is {}", decodeString(s));
        log.info("The decoded string is better approach {}", decodeStringBetter(s));
    }


    /*
     * Approach:
     * 1. keep str for the string to be repeated number times
     * 2. if incoming not a closing brace just push it to the stack if it is closing till open comes in the stack pop it to str and append reversely
     * 3. then pop the open brace and then check the number of times this string to be repeated by popping numbers from stack
     * 4. now repeat the str * number times and push back to the stack
     * 5. at the end just pop all the strings and merge reversely and return
     *
     * */

    /*
     * T: O(n * m) -> m is the max char inside the []
     * S: O(n)
     * */
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder str;
        StringBuilder number;

        for (char ch : s.toCharArray()) {
            str = new StringBuilder(); /*to hold string to be repeated*/
            number = new StringBuilder(); /*number of times a string to be repeated*/

            if (ch == ']') { /*when there is a closing*/
                while (!stack.peek().equals("[")) /*till open branch add the string elements*/
                    str.insert(0, stack.pop());

                stack.pop(); /*remove the open brace*/

                while (!stack.isEmpty() && stack.peek().length() == 1 && (Character.isDigit(stack.peek().charAt(0))))
                    number.insert(0, stack.pop()); /*get the numbe of times it needs to be repeated*/

                if (!number.isEmpty()) {
                    int intNum = Integer.parseInt(number.toString());
                    String repeat = str.toString().repeat(intNum); /*create repeated string*/
                    stack.push(repeat); /*push it to stack*/
                }
            } else {
                stack.push(String.valueOf(ch)); /*if it is not a closing brace just push it to stack*/
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()); /*merge all the decoded string*/
        }
        return result.toString();
    }

    /*
     * Approach: 02
     * 1. 1 stack to maintain the number and 1 for the str and the current for the final result
     * 2. if the char is a alphabet just append it to the current
     * 3. if the incoming char is number convert this to the number
     * 4. if it open brace push it to the str stack and the count of it in the count stack as a number
     * 5. once we have closing brace pop the countStack and repeat the current str those many times and pop the str and append the previous str
     * 6. at the end return the current
     * */

    public static String decodeStringBetter(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { /*to create the number*/
                num = num * 10 + (c - '0');
            } else if (c == '[') { /* if it is a open brace just plush the count and string to stack and reset them*/
                countStack.push(num);
                strStack.push(current);
                num = 0;
                current = new StringBuilder();
            } else if (c == ']') { /*when it is closing just pop the last pushed and count and repeat it with current and append to previous */
                int repeat = countStack.pop();
                StringBuilder prev = strStack.pop();
                prev.append(current.toString().repeat(repeat));
                current = prev;
            } else {
                current.append(c); /*if it is just alphabet just append to the current*/
            }
        }

        return current.toString();
    }

}
