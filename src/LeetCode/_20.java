package LeetCode;

// 20. Valid Parentheses

import java.util.Stack;

/** <a href="https://leetcode.com/problems/valid-parentheses/">...</a> */

public class _20 {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValidByStack(s));
    }

    // my solution, violates rule 2, accepts "([)]" as valid.
    public static boolean isValid(String s) {
        if (s.length() <= 1) return false;
        int parenthesesCount = 0; // ()
        int squareBracketsCount = 0; // []
        int bracesCount = 0; // {}
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') parenthesesCount++;
            else if (s.charAt(i) == '[' || s.charAt(i) == ']') squareBracketsCount++;
            else if (s.charAt(i) == '{' || s.charAt(i) == '}') bracesCount++;
        }
        return parenthesesCount % 2 == 0 && squareBracketsCount % 2 == 0 && bracesCount % 2 == 0;
    }

    public static boolean isValidByStack(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // Push opening brackets onto stack
                stack.push(c);
            } else {
                // Handle closing brackets
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }

                char top = stack.pop();

                // Check if the closing bracket matches the most recent opening bracket
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // Stack should be empty if all brackets were properly closed
        return stack.isEmpty();

    }
}
