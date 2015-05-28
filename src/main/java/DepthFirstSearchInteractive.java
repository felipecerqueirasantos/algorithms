import java.util.Stack;

/**
 * Created by sky on 07/05/15.
 */
public class DepthFirstSearchInteractive {
    public static final class Node<T extends Comparable<T>> {
        private T value;

        private Node<T> right;
        private Node<T> left;
        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> Node<T> insertBinarySearchTree(Node<T> node, T value) {
        if (node == null) return new Node<>(value);

        if (value.compareTo(node.value) > 0)
            node.right = insertBinarySearchTree(node.right, value);
        else
            node.left = insertBinarySearchTree(node.left, value);

        return node;
    }

    public static <T extends Comparable<T>> void depthFirstSearchInteractive(Node<T> root) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

        }
    }

    public static void main(String[] args) {


    }
}
