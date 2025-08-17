package LeetCode.SOLVED;

// 268. Missing Number

/**
 * <a href="https://leetcode.com/problems/missing-number/?envType=problem-list-v2&envId=array">...</a>
 */

public class _268 {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));

        nums = new int[]{0, 1};
        System.out.println(missingNumber(nums));

        nums = new int[]{3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static int missingNumberXOR(int[] nums) {
        // XOR has properties: a^a=0 and a^0=a
        // XOR all numbers from 0 to n with their indices
        // The missing number will remain as all other numbers cancel out
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum ^= i ^ nums[i];
        }
        return sum;
    }
}
