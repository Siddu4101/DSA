package org.example.patternVice.intervals;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class MergeIntervals {
    /*
     * Q:https://leetcode.com/problems/merge-intervals/description/
56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:
Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
     * */
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        log.info("After merge {}", Arrays.deepToString(merge(intervals)));
    }
    /*
     * Approach:
     * 1. sort by start to get the overlapping
     * 2. if found overlapping (previousEnd >= currentStart) update the end and move to next interval once it break add to result
     * 3. else it is non-overlapping so just add and move to next
     * */

    /*
     * T: O(n*logn)
     * S: O(n)
     * */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);/*sort by start to find overlapping */

        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (j <= intervals.length) { /* <=  because we are comparing wrt previous(i) so j compare happens on length*/
            while (j < intervals.length && intervals[i][1] >= intervals[j][0]) { /*till we have overlap merge the sequence*/
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]); /*update the end as we sorted by start*/
                j++;
            }
            result.add(intervals[i]); /*once merge is done or no overlapping just add it to the result */
            i = j; /*move the i and j to next interval*/
            j++;
        }
        return result.toArray(new int[][]{});
    }
}
