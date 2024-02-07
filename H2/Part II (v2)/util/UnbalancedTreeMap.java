package util;

import java.util.ArrayList;

public class UnbalancedTreeMap {
    private int size;
    BinaryNode<OrderedKeyValue> root;

    public UnbalancedTreeMap() {
        size = 0;
        root = null;
    }

    public int get(String key) {
        BinaryNode<OrderedKeyValue> temp = root;
        while (temp != null) {
            int comp = temp.element.compareTo(new OrderedKeyValue(key, 0));
            if (comp == 0)
                return temp.element.value;
            if (comp > 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return 0;
    }

    public int put(String key, int value) {
        if (root == null) {
            root = new BinaryNode<>(new OrderedKeyValue(key, value));
            size++;
            return 0;
        }

        BinaryNode<OrderedKeyValue> parent = null, child = root;
        do {
            int comp = child.element.compareTo(new OrderedKeyValue(key, 0));
            if (comp == 0) {
                int rv = child.element.value;
                child.element.value = value;
                return rv;
            }

            parent = child;
            if (comp > 0) {
                child = child.left;
            } else {
                child = child.right;
            }
        } while (child != null);

        if (parent.element.compareTo(new OrderedKeyValue(key, 0)) > 0) {
            parent.left = new BinaryNode<>(new OrderedKeyValue(key, value));
        } else {
            parent.right = new BinaryNode<>(new OrderedKeyValue(key, value));
        }
        size++;
        return 0;
    }

    public String[] keySet() {
        ArrayList<OrderedKeyValue> keyValues = inOrderList(root);
        String[] rv = new String[keyValues.size()];
        int i = 0;
        for (OrderedKeyValue kv : keyValues)
            rv[i++] = kv.key;
        return rv;
    }

    private ArrayList<OrderedKeyValue> inOrderList(BinaryNode<OrderedKeyValue> node) {
        ArrayList<OrderedKeyValue> list = new ArrayList<>();
        if (node == null)
            return list;

        list.addAll(inOrderList(node.left));
        list.add(node.element);
        list.addAll(inOrderList(node.right));

        return list;
    }
}
