package tree;

public class MaximumDepthOfBinaryTree {

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
     * Returns the maximum depth of a binary tree
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h) - recursion stack
     */
    public static int maxDepth(TreeNode root) {
        // Base case: empty tree
        if (root == null) {
            return 0;
        }

        // Compute depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Depth of current node
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root)); // 3
    }
}
