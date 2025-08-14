//package LeetCode;
//
//// 94. Binary Tree Inorder Traversal
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/">...</a>
// */
//
//public class _94 {
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//
//        System.out.println(inorderTraversal(root));
//    }
//
//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
////        inorderRecursive(root, result);
//        result = inorderIterative(root);
//        return result;
//    }
//
//    private static void inorderRecursive(TreeNode node, List<Integer> result) {
//        if (node == null) return;
//        inorderRecursive(node.left, result);
//        result.add(node.val);
//        inorderRecursive(node.right, result);
//    }
//
//    public static List<Integer> inorderIterative(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root;
//
//        while (current != null || !stack.isEmpty()) {
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//            current = stack.pop();
//            result.add(current.val);
//            current = current.right;
//        }
//        return result;
//
//    }
//}
