package LeetCode.Easy;

// 13. Roman to Integer

/**
 <a href="https://leetcode.com/problems/roman-to-integer/description/">...</a>
 */

/*
Solution:

### Main Method: `romanToInt`
This method takes a Roman numeral string as input and returns its integer value. Here's how it works:

1. It processes the Roman numeral from right to left (notice `i = s.length() - 1; i >= 0; i--`)
2. Uses two variables:
   - `result`: stores the final integer value
   - `prevValue`: keeps track of the previous Roman numeral's value

### Helper Method: `getValue`
This method converts individual Roman numeral characters to their corresponding integer values:
- I = 1
- V = 5
- X = 10
- L = 50
- C = 100
- D = 500
- M = 1000

### The Algorithm
The code uses a clever approach based on how Roman numerals work:

1. If the current numeral is greater than or equal to the previous one, add its value
2. If the current numeral is less than the previous one, subtract its value

For example, for "XIV" (14):
```
1. Start from right: 'V' (value=5)
   - First number, so add 5
   - result = 5, prevValue = 5

2. Next is 'I' (value=1)
   - 1 < 5, so subtract 1
   - result = 4, prevValue = 1

3. Finally 'X' (value=10)
   - 10 > 1, so add 10
   - result = 14
```


This handles special cases like "IV" (4) or "IX" (9) automatically, where smaller values come before larger ones to indicate subtraction.

The code is efficient with O(n) time complexity, where n is the length of the input string.
*/

public class _13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMMCMXCIX"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = getValue(s.charAt(i));

            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    private static int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
