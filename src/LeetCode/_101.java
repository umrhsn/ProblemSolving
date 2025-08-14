package LeetCode;

// 101. Symmetric Tree

/**
 <a href="https://leetcode.com/problems/symmetric-tree/description/">...</a>
 */

public class _101 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root2));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        return (root.left.val == root.right.val)
                && isSymmetric(root.left.left, root.right.right)
                && isSymmetric(root.left.right, root.right.left);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return (left.val == right.val)
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
