
package LeetCode.SOLVED;

// 169. Majority Element

import LeetCode.Stopwatch;

import java.util.Arrays;

/**
 <a href="https://leetcode.com/problems/majority-element/description/?envType=problem-list-v2&envId=array">...</a>
 */

public class _169 {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Input: " + Arrays.toString(nums1));
        Stopwatch sw = new Stopwatch();
        sw.reset();
        System.out.println("Naive: " + majorityElementNaive(nums1));
        System.out.println(sw);
        sw.reset();
        System.out.println("Boyer-Moore: " + majorityElementBoyerMoore(nums1));
        System.out.println(sw);
        System.out.println();

        System.out.println("Input: " + Arrays.toString(nums2));
        sw.reset();
        System.out.println("Naive: " + majorityElementNaive(nums2));
        System.out.println(sw);
        sw.reset();
        System.out.println("Boyer-Moore: " + majorityElementBoyerMoore(nums2));
        System.out.println(sw);
    }

    // O(n^2) time, O(1) space - Naive solution
    public static int majorityElementNaive(int[] nums) {
        int number = nums[0];
        if (nums.length == 1) return number;
        int i = 0;
        while (i < nums.length) {
            int counter = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) counter++;
                if (counter > nums.length / 2) {
                    number = nums[i];
                    break;
                }
            }
            i++;
        }
        return number;
    }

    // O(n) time, O(1) space - Boyer-Moore Voting Algorithm
    public static int majorityElementBoyerMoore(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
