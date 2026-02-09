package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    // Definition of tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Preorder Traversal
     * Order: Root -> Left -> Right
     */
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " "); // visit root
        preorder(root.left);              // visit left subtree
        preorder(root.right);             // visit right subtree
    }

    /**
     * Inorder Traversal
     * Order: Left -> Root -> Right
     */
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);               // visit left subtree
        System.out.print(root.val + " "); // visit root
        inorder(root.right);              // visit right subtree
    }

    /**
     * Postorder Traversal
     * Order: Left -> Right -> Root
     */
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);             // visit left subtree
        postorder(root.right);            // visit right subtree
        System.out.print(root.val + " "); // visit root
    }

    /**
     * Level Order Traversal (Breadth First Search)
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    /**
     * Main method to test traversals
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.print("Level Order: ");
        levelOrder(root);
    }
}
