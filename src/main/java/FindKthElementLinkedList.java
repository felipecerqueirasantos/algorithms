/**
 * Created by sky on 5/5/15.
 */
public class FindKthElementLinkedList {
    // Nested class to represent a linked list node
    private static final class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }

    public static <T> void findKthToLast(Node<T> head, int k) throws RuntimeException {
        Node<T> current = head;
        for (int i = 0; i < k + 1; i++) {
            if (current.next == null) {
                throw new IllegalArgumentException("k out of bound");
            }

            current = current.next;
        }

        Node<T> kth = head;
        while (current != null) {
            current = current.next;
            kth = kth.next;
        }

        System.out.println(kth.value);
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(10);
        head.next = new Node<>(11);
        head.next.next = new Node<>(12);
        head.next.next.next = new Node<>(13);
        head.next.next.next.next = new Node<>(14);
        head.next.next.next.next.next = new Node<>(15);

        findKthToLast(head, 0);
    }
}
