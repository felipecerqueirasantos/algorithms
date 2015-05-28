/**
 * Created by sky on 5/27/15.
 */
public class InvertLLPairWise {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public String toString() {
            return "[" + value + "]";
        }
    }

    public static <T extends Comparable<T>> Node<T> invertPairWise(Node<T> head) {
        Node<T> newRoot = head.next;
        Node<T> prev = head;
        Node<T> curr = head;
        Node<T> next = head.next;

        while (curr != null && curr.next != null) {
            Node<T> saved = next.next;
            next.next = curr;
            curr.next = saved;

            if (prev != null) {
                prev.next = next;
            }

            prev = curr;
            curr = saved;

            if (curr != null)
                next = curr.next;
        }

        return newRoot;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.next = new Node<>(2);
        root.next.next = new Node<>(3);
        root.next.next.next = new Node<>(4);
        root.next.next.next.next = new Node<>(5);
        root.next.next.next.next.next = new Node<>(6);

        Node<Integer> n = invertPairWise(root);

        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }
}
