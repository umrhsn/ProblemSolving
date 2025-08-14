package LeetCode;

// 9. Palindrome Number

/**
 <a href="https://leetcode.com/problems/palindrome-number/description/">...</a>
 */

public class _9 {
    public static void main(String[] args) {
        System.out.println(isPalindromeWithoutString(121));
    }

    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        int len = xStr.length();
        for (int i = 0; i < len / 2; i++) {
            if (xStr.charAt(i) != xStr.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeWithoutString(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
