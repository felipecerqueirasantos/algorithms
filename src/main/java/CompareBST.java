/**
 * Created by sky on 5/28/15.
 */

public class CompareBST {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean compareBST(Node<T> node1, Node<T> node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        if (node1.value.compareTo(node2.value) != 0) {
            return false;
        }

        return compareBST(node1.left, node2.left) && compareBST(node1.right, node2.right);
    }

    public static void main(String[] args) {
        Node<Integer> tree1 = new Node<>(10);
        tree1.right = new Node<>(20);
        tree1.left = new Node<>(8);

        Node<Integer> tree2 = new Node<>(10);
        tree2.right = new Node<>(20);
        tree2.left = new Node<>(8);
        tree2.left.left = new Node<>(6);

        System.out.println(compareBST(tree1, tree2));
    }
}