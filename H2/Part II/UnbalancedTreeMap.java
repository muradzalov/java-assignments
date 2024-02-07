import util.BinaryNode;
import java.util.ArrayList;

public class UnbalancedTreeMap {
    BinaryNode<OrderedKeyValue> root;

    public UnbalancedTreeMap() {
        this.root = null;
    }

    public int get(String key) {
        return get(root, key);
    }

    private int get(BinaryNode<OrderedKeyValue> node, String key) {
        if (node == null) {
            return 0;
        }

        int cmp = key.compareToIgnoreCase(node.element.key);

        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.element.value;
        }
    }

    public int put(String key, int value) {
        root = put(root, key, value);
        return value;
    }

    private BinaryNode<OrderedKeyValue> put(BinaryNode<OrderedKeyValue> node, String key, int value) {
        if (node == null) {
            return new BinaryNode<>(new OrderedKeyValue(key, value));
        }

        int cmp = key.compareToIgnoreCase(node.element.key);

        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.element.value = value;
        }

        return node;
    }

    public String[] keySet() {
        ArrayList<String> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys.toArray(new String[0]);
    }

    private void inOrder(BinaryNode<OrderedKeyValue> node, ArrayList<String> keys) {
        if (node == null) {
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.element.key);
        inOrder(node.right, keys);
    }

    public static void main(String[] args) {
        UnbalancedTreeMap map = new UnbalancedTreeMap();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        System.out.println("apple: " + map.get("apple"));  // Should print 10
        System.out.println("banana: " + map.get("banana"));  // Should print 20
        System.out.println("Unknown: " + map.get("Unknown"));  // Should print 0

        String[] keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);  // Should print "apple", "banana", "cherry" in alphabetical order
        }
    }
}
