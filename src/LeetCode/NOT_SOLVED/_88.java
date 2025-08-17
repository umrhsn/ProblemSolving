package LeetCode.NOT_SOLVED;

// 88. Merge Sorted Array

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/description/">...</a>
 */

public class _88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, nums1.length, nums2, nums2.length);
        for (int num : nums1) {
            System.out.print(num + ",");
        }
        // it should be [1,2,2,3,5,6]
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // End of nums1 valid elements
        int p2 = n - 1; // End of nums2
        int p = nums1.length - 1; // End of merged array

        // Continue while there are elements in nums2 to merge
        while (p2 >= 0) {
            // If nums1 has elements and current nums1 element is larger
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1]; // Write larger element from nums1
                p1--; // Move nums1 pointer left
            } else {
                nums1[p] = nums2[p2]; // Write element from nums2
                p2--; // Move nums2 pointer left
            }
            p--; // Move write position left
        }
    }
}
