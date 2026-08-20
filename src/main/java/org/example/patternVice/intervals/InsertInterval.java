package org.example.patternVice.intervals;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class InsertInterval {
    /*
     * Q:https://leetcode.com/problems/insert-interval/description/
57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Two intervals are considered overlapping if they share at least one point.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     * */
    public static void main(String[] args) {
        int[][] intervals =
                {{1, 5}};
        //                {{1, 3}, {6, 9}};
        //                {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval =
                {6, 8};
        //                {2, 5};
        //                {4, 8};
        log.info("The updated array is {}", Arrays.deepToString(insert(intervals, newInterval)));
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        //        if (intervals.length == 0)
        //            return new int[][]{newInterval};
        //
        if (intervals[intervals.length - 1][1] < newInterval[0]) {
            List<int[]> list = Arrays.stream(intervals).collect(Collectors.toList());
            list.add(newInterval);
            return list.toArray(new int[][]{});
        }

        ArrayList<int[]> result = new ArrayList<>();
        //        int i = 0;
        //        int j = i + 1;
        //        while (j <= intervals.length) {
        //            if (intervals[i][1] < newInterval[0] && intervals[j][0] > newInterval[1]) {
        //                result.add(j, newInterval);
        //            } else
        //            if (intervals[i][1] >= newInterval[0]) {
        //                intervals[i][1] = Math.max(newInterval[1], intervals[i][1]);
        //                while (j < intervals.length && intervals[i][1] >= intervals[j][0]) {
        //                    intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
        //                    j++;
        //                }
        //                result.add(intervals[i]);
        //                i = j - 1;
        //            } else {
        //                result.add(intervals[i]);
        //            }
        //            j++;
        //            i++;
        //        }

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                int tempI = i;
                while (tempI < intervals.length && newInterval[1] >= intervals[tempI][0]) {
                    newInterval[0] = Math.min(newInterval[0], intervals[tempI][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[tempI][1]);
                    tempI++;
                }
                result.add(newInterval);
                i = tempI - 1;
            } else {
                result.add(intervals[i]);
            }
        }


        return result.toArray(new int[][]{});
    }
}
