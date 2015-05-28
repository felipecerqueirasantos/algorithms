/**
 * Created by sky on 07/05/15.
 */
public class InOrderSuccessor {
    public static final class Node<T extends Comparable<T>> {
        private T value;

        private Node<T> right;
        private Node<T> left;
        private Node<T> parent;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> Node<T> inOrderSuccessor(Node<T> node) {
        if (node == null) return null;
        if (node.right != null) {
            return leftMost(node.right);
        }

        Node<T> curr = node;
        Node<T> x = curr.parent;
        while (x != null && x.left != curr) {
            curr = x;
            x = x.parent;
        }
        return null;
    }

    private static <T extends Comparable<T>> Node<T> leftMost(Node<T> node) {
        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public static void main(String[] args) {

    }
}
