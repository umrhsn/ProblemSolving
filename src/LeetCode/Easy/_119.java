package LeetCode.Easy;

// 119. Pascal's Triangle II

import java.util.List;
import java.util.ArrayList;

/**
 <a href="https://leetcode.com/problems/pascals-triangle-ii/description/">...</a>
 */

public class _119 {
    public static void main(String[] args) {
        System.out.println(getRow(3)); // Expected: [1,3,3,1]
        System.out.println(getRow(0)); // Expected: [1]
        System.out.println(getRow(1)); // Expected: [1,1]
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }

        return row;
    }
}
