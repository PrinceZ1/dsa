package tree;

public class BinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Inserts a value into the Binary Search Tree
     *
     * Time Complexity: O(h)
     * Space Complexity: O(h) (recursion stack)
     */
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        // If val == root.val, do nothing (no duplicates)

        return root;
    }

    /**
     * Searches for a value in the Binary Search Tree
     *
     * Time Complexity: O(h)
     * Space Complexity: O(h)
     */
    public static boolean search(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (val == root.val) {
            return true;
        }

        if (val < root.val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    /**
     * Deletes a value from the Binary Search Tree
     *
     * Time Complexity: O(h)
     * Space Complexity: O(h)
     */
    public static TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            // Case 1: node has no children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: node has one child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // Case 3: node has two children
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }

        return root;
    }

    /**
     * Finds the minimum value node in a subtree
     */
    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Prints the tree using inorder traversal
     */
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = null;

        // Insert nodes
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        inorder(root); // 20 30 40 50 60 70 80
        System.out.println();

        System.out.println(search(root, 40));  // true
        System.out.println(search(root, 100)); // false

        root = delete(root, 20); // delete leaf
        root = delete(root, 30); // delete node with one child
        root = delete(root, 50); // delete node with two children

        inorder(root); // 40 60 70 80
    }
}
