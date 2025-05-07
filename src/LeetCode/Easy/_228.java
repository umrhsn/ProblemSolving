package LeetCode.Easy;

// 228. Summary Ranges

import java.util.ArrayList;
import java.util.List;

/**
 <a href="https://leetcode.com/problems/summary-ranges/description/?envType=problem-list-v2&envId=array">...</a>
 * Given a sorted unique integer array, returns a list of ranges that cover all numbers.
 * Each range [a,b] is represented as:
 * - "a->b" if a != b
 * - "a" if a == b
 */

public class _228 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int start = nums[0];

        // Iterate through the array looking for breaks in consecutive numbers
        for (int i = 0; i < nums.length; i++) {
            // If we're at the end or found a break in consecutive numbers
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                // Build the range string
                StringBuilder range = new StringBuilder();
                range.append(start);
                if (start != nums[i]) {
                    range.append("->").append(nums[i]);
                }
                result.add(range.toString());
                // Set the start of the next range if not at the end
                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }

        return result;
    }
}
