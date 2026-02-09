package tree;

public class LowestCommonAncestor {

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
     * Finds the lowest common ancestor (LCA) of two nodes in a binary tree
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h) - recursion stack
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If p and q are found in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child
        return left != null ? left : right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left.left;   // 6
        TreeNode q = root.left.right;  // 2

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.val); // 5
    }
}
