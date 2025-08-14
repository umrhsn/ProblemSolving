package LeetCode;

// 66. Plus One

/**
 <a href="https://leetcode.com/problems/plus-one/description/">...</a>
 */

public class _66 {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 8};
        int[] result = plusOne(digits);
        for (int j : result) {
            System.out.print(j + ",");
        }
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
