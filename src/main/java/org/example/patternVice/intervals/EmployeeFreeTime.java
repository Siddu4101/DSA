package org.example.patternVice.intervals;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class EmployeeFreeTime {
    /*
    Q: https://www.hellointerview.com/learn/code/intervals/employee-free-time
Write a function to find the common free time for all employees from a list called schedule. Each employee's schedule is represented by a list of non-overlapping intervals sorted by start times. The function should return a list of finite, non-zero length intervals where all employees are free, also sorted in order.
Input:
schedule = [[[2,4],[7,10]],[[1,5]],[[6,9]]]
Output:
[(5,6)]

EX:2
schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
output = [5,6],[7,9]

Explanation: The three employees collectively have only one common free time interval, which is from 5 to 6.
    * */
    public static void main(String[] args) {
        int[][][] schedule = {{{1, 3}, {6, 7}}, {{2, 4}}, {{2, 5}, {9, 12}}};
        log.info("The all available schedules it {}", Arrays.deepToString(employeeFreeTime(schedule)));
    }


    /*
     * Approach:
     * 1. we no need to concentrate on each employee schedule as we need all employees common free time
     * 2. flatten the schedule sort by start time merge them where overlapping previousEnd >= currentStart
     * 3. now create e final result from the merged list were we see gap between the merged intervals
     * */

    /*
     * T: O(n * logn)
     * S: O(n)
     * */
    public static int[][] employeeFreeTime(int[][][] schedule) {
        int[][] flattenedArray = Arrays.stream(schedule).flatMap(Stream::of).toArray(int[][]::new); /*flatten the schedule*/
        flattenedArray = Arrays.stream(flattenedArray).sorted((a, b) -> a[0] - b[0]).toArray(int[][]::new); /*sort by start time*/

        ArrayList<int[]> mergedSchedule = new ArrayList<>();
        ArrayList<int[]> freeSchedule = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (j <= flattenedArray.length) {
            while (j < flattenedArray.length && flattenedArray[i][1] >= flattenedArray[j][0]) { /*till overlapping merge it*/
                flattenedArray[i][1] = Math.max(flattenedArray[i][1], flattenedArray[j][1]);
                j++;
            }
            mergedSchedule.add(flattenedArray[i]);
            i = j;
            j++;
        }

        for (int k = 0; k < mergedSchedule.size() - 1; k++) { /*get the free time between merged schedule*/
            freeSchedule.add(new int[]{mergedSchedule.get(k)[1], mergedSchedule.get(k + 1)[0]});
        }

        return freeSchedule.toArray(int[][]::new);
    }
}
