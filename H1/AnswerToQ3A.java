import util.*;

public class AnswerToQ3A {
    public static void main(String[] args) {
        // [5, 10, 15, 7, 3, 27, 14, 1]
        Node node1 = new Node(5);
        Node node2 = new Node(10);
        Node node3 = new Node(15);
        Node node4 = new Node(7);
        Node node5 = new Node(3);
        Node node6 = new Node(27);
        Node node7 = new Node(14);
        Node node8 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        SinglyLinkedList list = new SinglyLinkedList(node1);

        System.out.println("Before: " + list);
        removeValuesLargerThanMax(list, 13);
        System.out.println("After: " + list);
    }

    public static void removeValuesLargerThanMax(SinglyLinkedList list, int max) {
        Node prev = null;
        Node current = list.head;

        while (current != null) {
            int value = (Integer) current.data;

            if (value > max) {
                if (prev == null) {
                    list.head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
    }
}
