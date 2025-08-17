package LeetCode.SOLVED;

// 217. Contains Duplicate

import java.util.HashSet;
import java.util.Set;

/**
 <a href="https://leetcode.com/problems/contains-duplicate/description/?envType=problem-list-v2&envId=array">...</a>
 */

public class _217 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));

        nums = new int[]{1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));

        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));
    }

    // O(n)
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicates
    }

    // O(n²)
//    public static boolean containsDuplicate(int[] nums) {
//        if (nums.length <= 1) return false;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
