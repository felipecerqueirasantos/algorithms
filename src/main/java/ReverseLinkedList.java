/**
 * Created by sky on 5/3/15.
 */
public class ReverseLinkedList {
    public static final class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);

        printLinkedList(head);
        head = reverseLinkedList(head);
        printLinkedList(head);
    }

    private static void printLinkedList(Node<Integer> head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    private static Node<Integer> reverseLinkedList(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> prev = null;

        while (current != null) {
            Node t = current.next;
            current.next = prev;
            prev = current;
            current = t;
        }

        return prev;
    }
}
