package LeetCode;

// 104. Maximum Depth of Binary Tree

/**
 <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">...</a>
 */

public class _104 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        System.out.println(maxDepth(t1));

        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        System.out.println(maxDepth(t2));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
