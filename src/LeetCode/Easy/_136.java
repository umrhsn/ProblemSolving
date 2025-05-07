
package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

// 136. Single Number

/**
 <a href="https://leetcode.com/problems/single-number/description/">...</a>
 */

public class _136 {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();

        // Demonstrate with a large generated array
        int numPairs = 60_000_000;
        int uniqueValue = 123456789;
        int[] largeArray = generateLargeSingleNumberArray(numPairs, uniqueValue);

        int[][] testCases = {
                {2, 2, 1},
                {4, 1, 2, 1, 2},
                {1},
                largeArray
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Input: " + (i + 1));
            if (i == testCases.length - 1) {
                System.out.println("Large array generated: size = " + largeArray.length);
            }
            System.out.println();

            // 1. XOR
            stopwatch.reset();
            System.out.println("singleNumber (XOR):");
            System.out.println("Time Complexity: O(n)");
            System.out.println("Space Complexity: O(1)");
            System.out.println("Result: " + singleNumber(testCases[i]));
            System.out.println(stopwatch);

            // 2. Disguised XOR
            stopwatch.reset();
            System.out.println("singleNumberDisguisedXor (No ^):");
            System.out.println("Time Complexity: O(n)");
            System.out.println("Space Complexity: O(1)");
            System.out.println("Result: " + singleNumberDisguisedXor(testCases[i]));
            System.out.println(stopwatch);

            // 3. Sorting
            stopwatch.reset();
            System.out.println("singleNumberSorting:");
            System.out.println("Time Complexity: O(n log n)");
            System.out.println("Space Complexity: O(1)");
            System.out.println("Result: " + singleNumberSorting(testCases[i]));
            System.out.println(stopwatch);

            // 4. HashSet
            stopwatch.reset();
            System.out.println("singleNumberHashSet:");
            System.out.println("Time Complexity: O(n)");
            System.out.println("Space Complexity: O(n)");
            System.out.println("Result: " + singleNumberHashSet(testCases[i]));
            System.out.println(stopwatch);

            // 5. Math (Sum Trick)
            stopwatch.reset();
            System.out.println("singleNumberMath (Sum Trick):");
            System.out.println("Time Complexity: O(n)");
            System.out.println("Space Complexity: O(n)");
            System.out.println("Result: " + singleNumberMath(testCases[i]));
            System.out.println(stopwatch);

            if (i < testCases.length - 1) {
                System.out.println("=====================================================\n");
            }
        }
    }

    // 1. O(n) time, O(1) space - Standard XOR solution
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // 2. O(n) time, O(1) space - Disguised XOR (no ^ operator)
    public static int singleNumberDisguisedXor(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = bitwiseXor(result, num);
        }
        return result;
    }

    // XOR implemented using only AND, OR, and NOT
    private static int bitwiseXor(int a, int b) {
        // XOR truth table: (a AND NOT b) OR (NOT a AND b)
        return (a & ~b) | (~a & b);
    }

    // 3. O(n log n) time, O(1) space - Sorting solution
    public static int singleNumberSorting(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length); // Don't mutate input
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        // The single number is at the end
        return arr[n - 1];
    }

    // 4. O(n) time, O(n) space - HashSet solution
    public static int singleNumberHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        // Only the single number remains
        return set.iterator().next();
    }

    // 5. O(n) time, NOT O(1) space - Math sum trick (uses extra space for uniqueness)
    public static int singleNumberMath(int[] nums) {
        int sumOfUnique = 0;
        int sumOfAll = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            sumOfAll += num;
            if (seen.add(num)) {
                sumOfUnique += num;
            }
        }
        return 2 * sumOfUnique - sumOfAll;
    }

    /**
     * Generates an int array where every element appears exactly twice except for one unique element.
     * The unique element will be placed at a random position.
     *
     * @param numPairs Number of pairs (each value appears twice)
     * @param uniqueValue The unique value that appears only once
     * @return The generated array
     * @throws OutOfMemoryError if numPairs is too large for the available heap space
     */
    private static int[] generateLargeSingleNumberArray(int numPairs, int uniqueValue) {
        int size = numPairs * 2 + 1;
        int[] arr = new int[size];
        int val = 1;
        int idx = 0;
        // Fill pairs
        for (int i = 0; i < numPairs; i++) {
            arr[idx++] = val;
            arr[idx++] = val;
            val++;
            // Avoid collision with uniqueValue
            if (val == uniqueValue) val++;
        }
        // Insert unique value at a random position
        java.util.Random rand = new java.util.Random();
        int uniquePos = rand.nextInt(size);
        // Shift elements to make room for uniqueValue
        for (int i = size - 1; i > uniquePos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[uniquePos] = uniqueValue;
        return arr;
    }
}

/*
Input: 1

singleNumber (XOR):
Time Complexity: O(n)
Space Complexity: O(1)
Result: 1
Elapsed time:	000:00:00:00:000:501900

singleNumberDisguisedXor (No ^):
Time Complexity: O(n)
Space Complexity: O(1)
Result: 1
Elapsed time:	000:00:00:00:000:226200

singleNumberSorting:
Time Complexity: O(n log n)
Space Complexity: O(1)
Result: 1
Elapsed time:	000:00:00:00:000:905900

singleNumberHashSet:
Time Complexity: O(n)
Space Complexity: O(n)
Result: 1
Elapsed time:	000:00:00:00:000:407900

singleNumberMath (Sum Trick):
Time Complexity: O(n)
Space Complexity: O(n)
Result: 1
Elapsed time:	000:00:00:00:000:218800

=====================================================

Input: 2

singleNumber (XOR):
Time Complexity: O(n)
Space Complexity: O(1)
Result: 4
Elapsed time:	000:00:00:00:000:130300

singleNumberDisguisedXor (No ^):
Time Complexity: O(n)
Space Complexity: O(1)
Result: 4
Elapsed time:	000:00:00:00:000:098500

singleNumberSorting:
Time Complexity: O(n log n)
Space Complexity: O(1)
Result: 4
Elapsed time:	000:00:00:00:000:284700

singleNumberHashSet:
Time Complexity: O(n)
Space Complexity: O(n)
Result: 4
Elapsed time:	000:00:00:00:000:269600

singleNumberMath (Sum Trick):
Time Complexity: O(n)
Space Complexity: O(n)
Result: 4
Elapsed time:	000:00:00:00:000:188800

=====================================================

Input: 3

singleNumber (XOR):
Time Complexity: O(n)
Space Complexity: O(1)
Result: 1
Elapsed time:	000:00:00:00:000:127800

singleNumberDisguisedXor (No ^):
Time Complexity: O(n)
Space Complexity: O(1)
Result: 1
Elapsed time:	000:00:00:00:000:077500

singleNumberSorting:
Time Complexity: O(n log n)
Space Complexity: O(1)
Result: 1
Elapsed time:	000:00:00:00:000:154500

singleNumberHashSet:
Time Complexity: O(n)
Space Complexity: O(n)
Result: 1
Elapsed time:	000:00:00:00:000:342600

singleNumberMath (Sum Trick):
Time Complexity: O(n)
Space Complexity: O(n)
Result: 1
Elapsed time:	000:00:00:00:000:132800

=====================================================

Input: 4
Large array generated: size = 120000001

singleNumber (XOR):
Time Complexity: O(n)
Space Complexity: O(1)
Result: 123456789
Elapsed time:	000:00:00:00:080:686100

singleNumberDisguisedXor (No ^):
Time Complexity: O(n)
Space Complexity: O(1)
Result: 123456789
Elapsed time:	000:00:00:00:132:381100

singleNumberSorting:
Time Complexity: O(n log n)
Space Complexity: O(1)
Result: 123456789
Elapsed time:	000:00:00:00:901:045100

singleNumberHashSet:
Time Complexity: O(n)
Space Complexity: O(n)
Result: 123456789
Elapsed time:	000:00:00:02:660:417700

singleNumberMath (Sum Trick):
Time Complexity: O(n)
Space Complexity: O(n)
Result: 123456789
Elapsed time:	000:00:00:10:544:059600
*/