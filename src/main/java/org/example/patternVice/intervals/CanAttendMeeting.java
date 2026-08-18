package org.example.patternVice.intervals;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

@Slf4j
public class CanAttendMeeting {

    /*
     * Q: https://www.hellointerview.com/learn/code/intervals/can-attend-meetings
Write a function to check if a person can attend all the meetings scheduled without any time conflicts. Given an array intervals, where each element [s1, e1] represents a meeting starting at time s1 and ending at time e1, determine if there are any overlapping meetings. If there is no overlap between any meetings, return true; otherwise, return false.
Note that meetings ending and starting at the same time, such as (0,5) and (5,10), do not conflict.

Input:
intervals = [(1,5),(3,9),(6,8)]
Output:
false

Explanation: The meetings (1,5) and (3,9) overlap.
Input:
intervals = [(10,12),(6,9),(13,15)]
Output:
true
Explanation: There are no overlapping meetings, so the person can attend all.
     * */

    public static void main(String[] args) {
        int[][] intervals = // {{1, 5}, {3, 9}, {6, 8}};
                {{10, 12}, {6, 9}, {13, 15}};
        log.info("Is there any conflicts ? {}", canAttendMeetings(intervals));
    }

    /*
     * Approach:
     * 1. sort the intervals by start time so that overlapping intervals will become side by side
     * 2. then check the next meeting start time is before the current meeting endtime if yes return false else true
     *
     * */

    /*
     * T: O(n*logn) else O(n)--> for sorting
     * S: O(1)
     * */

    public static Boolean canAttendMeetings(int[][] intervals) {

        //        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        /*OR*/
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        log.info("sorted array {}", Arrays.deepToString(intervals));

        for (int k = 1; k < intervals.length; k++) {
            if (intervals[k][0] < intervals[k - 1][1])
                return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
