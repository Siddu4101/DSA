package org.example.neetcode150;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class EncodeAndDecodeMessage {

    /*
     * Q:https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode150(leetcode needs subscription for this question so doing it from neetcode)
     *
     *Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

        Machine 1 (sender) has the function:

        string encode(vector<string> strs) {
            // ... your code
            return encoded_string;
        }
        Machine 2 (receiver) has the function:

        vector<string> decode(string s) {
            //... your code
            return strs;
        }
        So Machine 1 does:

        string encoded_string = encode(strs);
        and Machine 2 does:

        vector<string> strs2 = decode(encoded_string);
        strs2 in Machine 2 should be the same as strs in Machine 1.

        Implement the encode and decode methods.

        Example 1:

        Input: dummy_input = ["Hello","World"]

        Output: ["Hello","World"]

        Explanation:
        Machine 1:
        Codec encoder = new Codec();
        String msg = encoder.encode(strs);
        Machine 1 ---msg---> Machine 2

        Machine 2:
        Codec decoder = new Codec();
        String[] strs = decoder.decode(msg);
     *
     * */

    public static void main(String[] args) {
        List<String> input = List.of("Hello", "World");
        String encode = encode(input);
        log.info("Encoded data is {}", encode);
        log.info("Decoded data is {}", decode(encode));
    }

    /*Approach 1*/
    /*here we are using the non-ascii char é as a delimiter for encode and decode*/
    public static String encode(List<String> strs) {
        return String.join("é", strs);
    }

    public static List<String> decode(String str) {
        return Arrays.stream(str.split("\\é")).toList();
    }
}
