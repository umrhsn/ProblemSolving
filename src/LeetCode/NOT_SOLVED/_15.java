package LeetCode.NOT_SOLVED;

// 15. 3Sum

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/3sum/description/?envType=problem-list-v2&envId=sorting">...</a>
 */

public class _15 {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("nums1: " + threeSum(nums1));

        int[] nums2 = {0, 1, 1};
        System.out.println("nums2: " + threeSum(nums2));

        int[] nums3 = {0, 0, 0};
        System.out.println("nums3: " + threeSum(nums3));

        int[] nums4 = {3, -2, 1, 0};
        System.out.println("nums4: " + threeSum(nums4));

        int[] nums5 = {-2, 0, 1, 1, 2};
        System.out.println("nums5: " + threeSum(nums5));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // [nums[i], nums[j], nums[k]]
        // i != j, i != k, and j != k
        // nums[i] + nums[j] + nums[k] == 0

        Arrays.sort(nums);

        Set<ArrayList<Integer>> triplets = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            for (int j = 0; j < nums.length - 2; j++) {

                if (i == j) continue;

                int num2 = nums[i + j];
                int num3 = nums[i + j + 1];

                if (num1 + num2 + num3 == 0) {
                    triplets.add(new ArrayList<>(Arrays.asList(num1, num2, num3)));
                }

            }
        }

        return new ArrayList<>(triplets);
    }
}
