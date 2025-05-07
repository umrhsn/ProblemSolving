package LeetCode.Easy;

// 111. Minimum Depth of Binary Tree

import java.util.LinkedList;
import java.util.Queue;

/**
 <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/description/">...</a>
 */

public class _111 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test 1: " + minDepth(root1));  // Expected output: 2

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        System.out.println("Test 2: " + minDepth(root2));  // Expected output: 5
    }

    // DFS solution
//    public static int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        if (root.left == null && root.right == null) return 1;
//        if (root.left == null) return minDepth(root.right) + 1;
//        if (root.right == null) return minDepth(root.left) + 1;
//        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
//    }

    // BFS solution
    public static int minDepth(TreeNode root) {
        // Handle empty tree case
        if (root == null) return 0;

        // Create two queues - one for nodes and one for their depths 
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();

        // Add root node with depth 1
        nodeQueue.offer(root);
        depthQueue.offer(1);

        // Process nodes level by level until queue is empty
        while (!nodeQueue.isEmpty()) {
            // Get next node and its depth from the queues
            TreeNode node = nodeQueue.poll();
            Integer depthBoxed = depthQueue.poll();
            // Handle potential null case, though shouldn't occur given queue check
            int depth = depthBoxed != null ? depthBoxed : 0;

            // If this is a leaf node, we've found the minimum depth path
            if (node.left == null && node.right == null) {
                return depth;
            }

            // Add left child if it exists
            if (node.left != null) {
                nodeQueue.offer(node.left);
                depthQueue.offer(depth + 1);
            }

            // Add right child if it exists
            if (node.right != null) {
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
            }
        }

        // This line is unreachable since a valid binary tree will always have at least one leaf
        return 0;
    }
}
