package LeetCode.SOLVED;


// 1. Two Sum

/**
 <a href="https://leetcode.com/problems/two-sum/">...</a>
 * */

public class _1 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        for (int i = 0; i < 2; i++) {
            System.out.print(twoSum(arr, 6)[i] + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int index1 = 0, index2 = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;

                if (nums[i] + nums[j] == target) {
                    index1 = j;
                    index2 = i;
                    break;
                }
            }
        }

        return new int[]{index1, index2};
    }
}
