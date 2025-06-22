package org.example.dsa.linearsearch.util;

public class SearchUtils {
    private SearchUtils() {
    }

    public static boolean linearSearch(int[] arr, int target) {
        if (arr.length == 0)
            return false;

        for (int j : arr) {
            if (j == target)
                return true;
        }
        return false;
    }

    public static boolean linerSearchForACharacter(String name, char target) {
        if (name.isEmpty())
            return false;

        for (char ch : name.toCharArray()) {
            if (ch == target)
                return true;
        }
        return false;
    }
}
