import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by sky on 5/10/15.
 */
public class ZigZag {
    // Nested class to represent a binary search tree node (requires Comparable)
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    // Print binary search tree in zigzag order
    public static <T extends Comparable<T>> void zigzapPrint(Node<T> root) {
        // Boundless queue
        Deque<Node<T>> queue = new ArrayDeque<>();
        boolean zigZag = true;

        queue.add(root);

        int currentLevel = 1;
        int nextLevel = 0;

        while (!queue.isEmpty()) {
            Node<T> node = null;

            if (zigZag) {
                node = queue.removeLast();
            } else {
                node = queue.removeFirst();
            }

            System.out.print(node.value + " ");
            currentLevel--;

            if (node.left != null) { queue.add(node.left); nextLevel++; }
            if (node.right != null) { queue.add(node.right); nextLevel++; }

            if (currentLevel == 0) {
                // Chaging level
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;

                zigZag = !zigZag;
            }
        }
    }

    /*
              1
            2   3
           4 5 6 7

           Queue = 1
           Queue = 32
           Queue = 673
           Queue = 5467
     */

    // Testing
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.right = new Node<>(3);
        root.left = new Node<>(2);

        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);

        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        zigzapPrint(root);
    }
}