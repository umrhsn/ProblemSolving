package LeetCode;

// 70. Climbing Stairs

/**
 <a href="https://leetcode.com/problems/climbing-stairs/description/">...</a>
 */

public class _70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(7));
    }

    /** Recursive approach O(2ⁿ), O(n)*/
    /*public static int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }*/

    /** Dynamic approach O(n), O(n)*/
    /*public static int climbStairs(int n) {
        // Base case - if n is 1 or 2, return n since there are n ways
        if (n <= 2) return n;

        // Create array to store number of ways to climb i stairs
        int[] waysToClimb = new int[n + 1];

        // Initialize base cases
        waysToClimb[1] = 1; // One way to climb 1 stair
        waysToClimb[2] = 2; // Two ways to climb 2 stairs: (1+1) or (2)

        // For each step, ways to reach it = ways to reach (i-1) + ways to reach (i-2)
        // Because we can climb either 1 or 2 stairs at a time
        for (int i = 3; i <= n; i++) {
            waysToClimb[i] = waysToClimb[i - 1] + waysToClimb[i - 2];
        }

        // Return total number of ways to climb n stairs
        return waysToClimb[n];
    }*/

    /** Optimized space approach O(n), O(1)*/
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int prev1 = 1; // ways to climb 1 stair
        int prev2 = 2; // ways to climb 2 stairs
        int current;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
