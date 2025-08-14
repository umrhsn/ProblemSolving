//package LeetCode;
//
//// 27. Remove Element
//
//import static java.util.Arrays.sort;
//
///**
// <a href="https://leetcode.com/problems/remove-element/description/">...</a>
// */
//
//public class _27 {
//    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3}; // Input array
//        int val = 3; // Value to remove
//        int[] expectedNums = {2, 2}; // The expected answer with correct length.
//        // It is sorted with no values equaling val.
//
//        int k = removeElement(nums, val); // Calls your implementation
//
//        assert k == expectedNums.length;
//        sort(nums, 0, k); // Sort the first k elements of nums
//        for (int i = 0; i < 2; i++) {
//            assert nums[i] == expectedNums[i];
//        }
//    }
//
//    public static int removeElement(int[] nums, int val) {
//
//    }
//}
