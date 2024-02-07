package part1;
import util.*;

public class Question1 {
    public static int countGreaterThanValue(BinaryNode<Integer> root, int value) {
        // Base case: if the node is null, return 0
        if (root == null) {
            return 0;
        }

        int count = 0;

        // Check the value of the current node
        if (root.element > value) {
            count++;
        }

        // Recursively traverse the left and right subtrees
        count += countGreaterThanValue(root.left, value);
        count += countGreaterThanValue(root.right, value);

        return count;
    }

    public static void main(String[] args) {
        // Create a test binary tree using BinaryNode<Integer>
        BinaryNode<Integer> root = new BinaryNode<>(4);
        root.left = new BinaryNode<>(2);
        root.right = new BinaryNode<>(7);
        root.left.left = new BinaryNode<>(1);
        root.left.right = new BinaryNode<>(3);
        root.right.left = new BinaryNode<>(5);
        root.right.right = new BinaryNode<>(9);

        // Test the countGreaterThanValue method
        int count = countGreaterThanValue(root, 3);
        System.out.println("Number of nodes greater than 3: " + count);
    }
}
