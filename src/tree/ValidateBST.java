package tree;

public class ValidateBST {

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
     * Checks if a binary tree is a valid Binary Search Tree
     */
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Helper method to validate BST using value range
     */
    private static boolean validate(TreeNode node, long min, long max) {
        // An empty tree is a valid BST
        if (node == null) {
            return true;
        }

        // Current node must be within the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree: values must be < node.val
        // Right subtree: values must be > node.val
        return validate(node.left, min, node.val)
                && validate(node.right, node.val, max);
    }

    /**
     * Main method to test the solution
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);

        System.out.println(isValidBST(root)); // false
    }
}
