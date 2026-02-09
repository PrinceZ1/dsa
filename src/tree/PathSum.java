package tree;

public class PathSum {

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
     * Checks if the binary tree has a root-to-leaf path
     * such that the sum of node values equals targetSum
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        // Empty tree cannot have a valid path
        if (root == null) {
            return false;
        }

        // If this is a leaf node, check the remaining sum
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Subtract current node value and continue searching
        int remainingSum = targetSum - root.val;

        return hasPathSum(root.left, remainingSum)
                || hasPathSum(root.right, remainingSum);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22)); // true
        System.out.println(hasPathSum(root, 26)); // true (5 -> 8 -> 13)
        System.out.println(hasPathSum(root, 18)); // false
    }
}
