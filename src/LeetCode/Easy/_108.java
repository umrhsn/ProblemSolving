package LeetCode.Easy;

// 108. Convert Sorted Array to Binary Search Tree


import java.util.Arrays;

/**
 <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/">...</a>
 */

public class _108 {
    public static void main(String[] args) {
//        int[] nums = {-10, -3, 0, 5, 9};
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = sortedArrayToBST(nums);
        printTree(root);
    }

    private static void printTree(TreeNode node) {
        System.out.print("[");
        printTreeHelper(node);
        System.out.print("]");
    }

    private static void printTreeHelper(TreeNode node) {
        if (node == null) {
            System.out.print("null,");
            return;
        }
        System.out.print(node.val + ",");
        if (node.left != null || node.right != null) {
            printTreeHelper(node.left);
            printTreeHelper(node.right);
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        int[] leftNums = Arrays.copyOfRange(nums, 0, mid);
        int[] rightNums = Arrays.copyOfRange(nums, mid + 1, nums.length);

        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);

        return root;
    }
}
