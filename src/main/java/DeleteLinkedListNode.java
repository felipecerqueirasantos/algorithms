/**
 * Created by sky on 5/5/15.
 */
public class DeleteLinkedListNode {
    // Nested class to represent a linked list node
    public static final class Node<T> {
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

    public static <T> void removeElement(Node<T> node) {
        Node<T> prev = node;
        Node<T> current = node.next;


        while (current != null) {
            prev.value = current.value;

            if (current.next == null)
                break;

            prev = current;
            current = current.next;
        }

        // Remove last element
        prev.next = null;
    }

    public static <T> void printLinkedList(Node<T> head) {
        Node<T> current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);

        removeElement(head);
        printLinkedList(head);
    }
}