package LeetCode;

// 118. Pascal's Triangle

import java.util.List;
import java.util.ArrayList;

/**
 <a href="https://leetcode.com/problems/pascals-triangle/description/">...</a>
 */

public class _118 {
    public static void main(String[] args) {
        int numRows = 5;
        //int numRows = 1;
        List<List<Integer>> list = generate(numRows);
        System.out.println(list);
    }

    public static List<List<Integer>> generate(int numRows) {
        // Initialize result list
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0) return triangle;

        // First row is always [1]
        triangle.add(List.of(1));
        if (numRows == 1) return triangle;

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
