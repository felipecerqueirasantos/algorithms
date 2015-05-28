import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sky on 5/6/15.
 */
public class ConnectSameDepth {
    // Nested class to represent a tree node
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;
        private Node<T> next;


        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + this.value + "]";
        }
    }

    public static <T extends Comparable<T>> void connectSameDepth(Node<T> root) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(root);
        Node<T> prev = null;

        int currentLevel = 1;
        int nextLevel = 0;

        while(!queue.isEmpty()) {
            Node<T> current = queue.remove();
            currentLevel--;

            if (prev != null) {
                prev.next = current;
            }

            prev = current;

            if (current.left != null) {
                queue.add(current.left);
                nextLevel++;
            }

            if (current.right != null) {
                queue.add(current.right);
                nextLevel++;
            }

            if (currentLevel == 0) {
                prev = null;
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public static <T extends Comparable<T>> void printNextElements(Node<T> node) {
        Node<T> current = node;
        int i = 0;
        while (current != null) {
            if (i++ > 0) System.out.print(" -> ");
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    /*
                1
              2   3
            4  5 6 7
           8         9
     */
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.left.right = new Node<>(5);
        root.left.left = new Node<>(4);
        root.left.left.left = new Node<>(8);

        root.right = new Node<>(3);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
        root.right.right.right = new Node<>(9);

        connectSameDepth(root);

        printNextElements(root);
        printNextElements(root.left);
        printNextElements(root.left.left);
        printNextElements(root.left.left.left);
    }
}