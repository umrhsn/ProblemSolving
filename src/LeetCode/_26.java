package LeetCode;

// 26. Remove Duplicates from Sorted Array

/**
 <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">...</a>
 */

public class _26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // Input array
        int[] expectedNums = {0, 1, 2, 3, 4}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

        System.out.println(k);
        printArray(nums);
    }

    public static int removeDuplicates(int[] nums) {
        // Handle edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initial position for unique elements
        int slowIndex = 1;

        // Iterate through the array starting from the second element
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            // If current element is different from the previous one
            if (nums[fastIndex] != nums[fastIndex - 1]) {
                // Place this unique element at the slowIndex position
                nums[slowIndex] = nums[fastIndex];
                // Move slowIndex forward
                slowIndex++;
            }
        }

        // slowIndex now represents the length of the array with duplicates removed
        return slowIndex;

    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}
