package LeetCode;

// 69. Sqrt(x)

/**
 <a href="https://leetcode.com/problems/sqrtx/description/">...</a>
 */

public class _69 {
    public static void main(String[] args) {
        int x = 15;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        // Handle edge cases
        if (x < 0) return -1;
        if (x == 0) return 0;
        if (x == 1) return 1;

        // Initialize binary search boundaries
        // Using long to prevent integer overflow
        long left = 1;
        long right = x;

        // Binary search to find square root
        while (left <= right) {
            // Calculate middle point
            // Using (right-left)/2 to prevent integer overflow
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            // Found exact square root
            if (square == x) {
                return (int) mid;
            }
            // Current guess is too small
            else if (square < x) {
                left = mid + 1;
            }
            // Current guess is too large
            else {
                right = mid - 1;
            }
        }

        // Return floor of the square root
        return (int) right;
    }
}
