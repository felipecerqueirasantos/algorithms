/**
 * Created by sky on 5/7/15.
 */
public class ReverseEachKNodesLinkedList {
    public static final class Node {
        // Simples node without generics to simplify
        private int i;
        private Node next;

        public Node(int i) {
            this.i = i;
        }

        public Node() {
            this(0);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverseEachKNodes(head, 3);

        printLinkedList(head);
    }

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.i);
            current = current.next;
        }
    }

    private static Node reverseEachKNodes(Node head, int k) {
        Node[] arr = new Node[k];
        int N = 0;

        Node current = head;
        Node newHead = null;

        while (current != null) {
            Node next = current.next;

            if (N == k) {
                if (newHead == null) {
                    // Set new head to the kth element of the list
                    newHead = arr[N - 1];
                }

                while (N >= 1) {
                    current.next = arr[N - 1];
                    current = arr[N - 1];
                    N--;
                }

                arr[N].next = current;
            }

            arr[N++] = current;
            current = next;
        }

        return newHead;
    }
}
