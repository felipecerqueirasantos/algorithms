/**
 * Created by sky on 5/26/15.
 */
public class MorrisTraversal {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }

    public static <T extends Comparable<T>> void morrisTraversal(Node<T> root) {
        Node<T> current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.println(current);
                current = current.right;
            } else {
                Node<T> leftChild = current.left;
                Node<T> tmp = leftChild;
                Node<T> rightMost = null;

                while (leftChild != null) {
                    rightMost = leftChild;
                    leftChild = leftChild.right;
                }

                rightMost.right = current;
                current.left = null;
                current = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);
        root.right = new Node<>(20);
        root.right.left = new Node<>(18);
        root.right.right = new Node<>(22);
        root.left = new Node<>(8);
        root.left.left = new Node<>(6);
        root.left.right = new Node<>(9);
        morrisTraversal(root);
    }
}
