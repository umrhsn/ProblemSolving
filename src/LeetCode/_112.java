package LeetCode;

// 112. Path Sum

/**
 <a href="https://leetcode.com/problems/path-sum/description/">...</a>
 */

public class _112 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(4);
        t1.left.left = new TreeNode(11);
        t1.left.left.left = new TreeNode(7);
        t1.left.left.right = new TreeNode(2);
        t1.right = new TreeNode(8);
        t1.right.left = new TreeNode(13);
        t1.right.right = new TreeNode(4);
        t1.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(t1, 22));

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        System.out.println(hasPathSum(t2, 5));

        System.out.println(hasPathSum(null, 0));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
