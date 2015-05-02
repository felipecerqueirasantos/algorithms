/**
 * Created by sky on 5/1/15.
 */
public class InsertSortedLinkedList {
    private static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private static Node insertSorted(Node head, Node newValue) {
        if (head == null)
            return newValue;

        Node prev = head;
        Node cur = head;

        while (cur != null) {
            if (newValue.value.compareTo(cur.value) <= 0) {
                if (cur == head) {
                    newValue.next = head;
                    return newValue;
                }

                newValue.next = cur;
                Node saved = prev.next;
                prev.next = newValue;
                newValue = saved;

                return head;
            }
            prev = cur;
            cur = cur.next;
        }

        prev.next = newValue;
        return head;
    }

    private static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Node<String> head = new Node<>("B");
        head.next = new Node<>("C");
        head.next.next = new Node<>("E");

        head = insertSorted(head, new Node<String>("A"));
        head = insertSorted(head, new Node<String>("D"));
        printList(head);
    }
}
