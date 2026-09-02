package org.example.patternVice.stack;

import lombok.extern.slf4j.Slf4j;

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
    }


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
}
