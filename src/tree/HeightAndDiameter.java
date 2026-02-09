package tree;

public class HeightAndDiameter {

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
     * Returns the height of the binary tree
     *
     * Height = number of edges in the longest path from root to a leaf
     */
    public static int height(TreeNode root) {
        if (root == null) {
            return -1; // empty tree
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * Calculates the diameter of the binary tree
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public static int diameter(TreeNode root) {
        int[] maxDiameter = new int[1]; // acts like a global variable
        calculateHeight(root, maxDiameter);
        return maxDiameter[0];
    }

    /**
     * Helper method to calculate height and update diameter
     */
    private static int calculateHeight(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return -1;
        }

        int leftHeight = calculateHeight(node.left, maxDiameter);
        int rightHeight = calculateHeight(node.right, maxDiameter);

        // Diameter passing through current node
        int currentDiameter = leftHeight + rightHeight + 2;
        maxDiameter[0] = Math.max(maxDiameter[0], currentDiameter);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println("Height: " + height(root));     // 2
        System.out.println("Diameter: " + diameter(root)); // 3
    }
}
