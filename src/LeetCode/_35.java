package LeetCode;

// 35. Search Insert Position

/**
 <a href="https://leetcode.com/problems/search-insert-position/description/">...</a>
 */

public class _35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 6;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return i;
    }
}
