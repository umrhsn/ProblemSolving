package LeetCode.Easy;

// 110. Balanced Binary Tree

/**
 <a href="https://leetcode.com/problems/balanced-binary-tree/description/">...</a>
 */

public class _110 {
    public static void main(String[] args) {
        // Test case 1: [3,9,20,null,null,15,7]
        TreeNode balanced = new TreeNode(3);
        balanced.left = new TreeNode(9);
        balanced.right = new TreeNode(20);
        balanced.right.left = new TreeNode(15);
        balanced.right.right = new TreeNode(7);
        System.out.println("Balanced tree test: " + isBalanced(balanced));  // Should print true

        // Test case 2: [1,2,2,3,3,null,null,4,4]
        TreeNode unbalanced = new TreeNode(1);
        unbalanced.left = new TreeNode(2);
        unbalanced.right = new TreeNode(2);
        unbalanced.left.left = new TreeNode(3);
        unbalanced.left.right = new TreeNode(3);
        unbalanced.left.left.left = new TreeNode(4);
        unbalanced.left.left.right = new TreeNode(4);
        System.out.println("Unbalanced tree test: " + isBalanced(unbalanced));  // Should print false

        // Test case 3: []
        System.out.println("Empty tree test: " + isBalanced(null));  // Should print true
    }

    /// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
