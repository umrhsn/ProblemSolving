package LeetCode;

// 219. Contains Duplicate II

import java.util.HashSet;
import java.util.Set;

/**
 <a href="https://leetcode.com/problems/contains-duplicate-ii/description/?envType=problem-list-v2&envId=array">...</a>
 */

public class _219 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums, 3));

        nums = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));

        nums = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

    public static boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        if (nums.length <= 1) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (!window.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
