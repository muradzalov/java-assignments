package part3;

import util.BinaryNode;

public class Question3 {
    public static BinaryNode removeLeaves(BinaryNode root) {
        // Check if the root is null or if it's a leaf node
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;

        // Post-order traversal: first visit the children, then the parent
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);

        return root;
    }

    public static void main(String[] args) {
        // Create a sample binary tree for testing
        BinaryNode<Integer> root = new BinaryNode<>(1);
        root.left = new BinaryNode<>(2);
        root.right = new BinaryNode<>(3);
        root.left.left = new BinaryNode<>(4);
        root.left.right = new BinaryNode<>(5);
        root.right.left = new BinaryNode<>(6);
        root.right.right = new BinaryNode<>(7);

        // Print original tree
        System.out.println("Original Tree:");
        root.printBFS();
        System.out.println();

        // Remove leaves
        root = removeLeaves(root);

        // Print modified tree
        System.out.println("Tree after removing leaves:");
        if (root != null) {
            root.printBFS();
        } else {
            System.out.println("Tree is empty");
        }
    }
}
