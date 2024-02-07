package part2;
import util.BinaryNode;

public class Question2 {
    // Wrapper function
    public static boolean isSymmetric(BinaryNode<Integer> root) {
        return root == null || isMirror(root.left, root.right);
    }

    // Helper function to check if two trees are mirror images of each other
    private static boolean isMirror(BinaryNode<Integer> left, BinaryNode<Integer> right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.element.equals(right.element)) &&
               isMirror(left.right, right.left) &&
               isMirror(left.left, right.right);
    }

    public static void main(String[] args) {
        // Construct the tree
        BinaryNode<Integer> root = new BinaryNode<>(1);
        root.left = new BinaryNode<>(2);
        root.right = new BinaryNode<>(2);
        root.left.left = new BinaryNode<>(3);
        root.left.right = new BinaryNode<>(4);
        root.right.left = new BinaryNode<>(4);
        root.right.right = new BinaryNode<>(3);

        // Check if tree is symmetric
        boolean result = isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }
}
