import util.*;

public class AnswerToQ3B {
    private static SinglyLinkedList createCircularLinkedList(int n) {
        SinglyLinkedList pens = new SinglyLinkedList(new Node(1));
        Node cur = pens.head;

        for (int i = 2; i <= n; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }

        cur.next = pens.head; 
        return pens;
    }

    private static void printCircularLinkedList(SinglyLinkedList list) {
        if (list.head == null) return;
        
        Node cur = list.head;
        do {
            System.out.printf("%s%s", cur.data, cur.next == list.head ? "" : " -> ");
            cur = cur.next;
        } while (cur != list.head);
        System.out.println();
    }

    public static int findLastRemainingPen(int n, int k, boolean verbose) {
        if (n < 1 || k < 1) {
            if (verbose) System.out.println("Error: Invalid input values.");
            return -1;
        }

        SinglyLinkedList pens = createCircularLinkedList(n);
        if (verbose) printCircularLinkedList(pens);

        Node cur = pens.head;
        Node prev = cur;

        while (prev.next != cur) {
            prev = prev.next;
        }

        while (cur != prev) {
            for (int i = 0; i < k - 1; i++) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;

            if (cur == pens.head) {
                pens.head = cur.next;
            }

            cur = cur.next;

            if (verbose) printCircularLinkedList(pens);
        }

        return (int) cur.data;
    }

    public static void main(String[] args) {
        int solution = findLastRemainingPen(10, 4, true);
        System.out.printf("The last remaining pen for Bob with n = %d and k = %d is %d\n", 10, 4, solution);
    }
}
