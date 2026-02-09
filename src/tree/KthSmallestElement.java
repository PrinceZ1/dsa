package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElement {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Approach 1: Inorder Traversal + List
     * ------------------------------------
     * Inorder traversal of a BST produces a sorted sequence.
     * The kth smallest element is at index (k - 1).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int kthSmallestUsingList(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return inorderList.get(k - 1);
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    /**
     * Approach 2: Recursive Inorder + Counter
     * ------------------------------------
     * Traverse the BST using inorder traversal.
     * Stop as soon as the counter reaches k.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)  (recursion stack)
     */
    private int count;
    private int result;

    public int kthSmallestUsingCounter(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorderWithCounter(root, k);
        return result;
    }

    private void inorderWithCounter(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inorderWithCounter(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorderWithCounter(node.right, k);
    }

    /**
     * Approach 3: Iterative Inorder using Stack
     * ------------------------------------
     * Simulate recursive inorder traversal using an explicit stack.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public int kthSmallestUsingStack(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;

            if (count == k) {
                return current.val;
            }

            current = current.right;
        }

        return -1;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestElement test = new KthSmallestElement();

        System.out.println("Using List: " + test.kthSmallestUsingList(root, 3));
        System.out.println("Using Counter: " + test.kthSmallestUsingCounter(root, 3));
        System.out.println("Using Stack: " + test.kthSmallestUsingStack(root, 3));
    }
}
