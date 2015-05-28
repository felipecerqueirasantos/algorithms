/**
 * Created by sky on 5/5/15.
 */
public class RemoveDuplicates {
    // Private nested class to represent a linked list node
    private static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    /*
     * Method that will remove duplicated nodes
     */
    public static <T extends Comparable<T>> void removeDuplicates(Node<T> head) {
        Node<T> current = head;

        while (current != null) {
            removeDuplicates(current, current.value);
            current = current.next;
        }
    }

    /*
     * Iterate through all linked list elements finding for repetition
     */
    private static <T extends Comparable<T>> void removeDuplicates(Node<T> node, T value) {
        Node<T> prev = node;

        if (prev.next == null)
            return;

        Node<T> current = prev.next;

        while (current != null) {
            if (current.value.compareTo(value) == 0) {
                prev.next = current.next;
                current = current.next;
            }

            prev = current;
            if (current != null)
                current = current.next;
        }
    }

    public static <T extends Comparable<T>> void printList(Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        // Linked list head
        Node<Integer> head = new Node<>(10);

        head.next = new Node<>(20);
        head.next.next = new Node<>(20);
        head.next.next.next = new Node<>(30);
        head.next.next.next.next = new Node<>(30);

        removeDuplicates(head);
        printList(head);
    }
}