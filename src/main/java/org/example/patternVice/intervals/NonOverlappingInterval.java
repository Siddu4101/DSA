package org.example.patternVice.intervals;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

@Slf4j
public class NonOverlappingInterval {

    /*
     * Q:https://leetcode.com/problems/non-overlapping-intervals/
435. Non-overlapping Intervals
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     *
     * */
    public static void main(String[] args) {
        int[][] intervals =
                {{1, 100}, {2, 3}, {4, 5}};
        //                {{1, 2}, {1, 2}, {1, 2}};
        //                {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        //                {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        //                {{1, 10}, {2, 3}, {4, 5}, {6, 7}, {8, 9}};
        log.info("The min overlapping elements to be removed is {}", eraseOverlapIntervals(intervals));
    }

    /*
     * Approach:
     * 1. sort array by end time to identify meetings getting over early
     * 2. overlapping =  previousMeetingEndTime > nextMeetingStartTime so consider overlap and remove it(increment overlap)
     * 3. if it is not overlapping move to the next meeting and also move the previousMeetingEndTime as u considered that as non-overlapping
     * */
    /*
     * T: O(n * logn)(sort) or O(n)
     * S: O(1)
     * */
    public static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length <= 1)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); /*early completion meetings at first*/

        int overlapping = 0;
        int previousMeetingEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (previousMeetingEnd > intervals[i][0])/*overlaps so consider for removal*/
                overlapping++;
            else
                previousMeetingEnd = intervals[i][1];/*move to next one*/
        }
        return overlapping;
    }
}
