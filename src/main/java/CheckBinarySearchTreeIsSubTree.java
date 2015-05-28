import java.util.Stack;

/**
 * Created by sky on 06/05/15.
 */
/*
 * Check whether a tree s2 is subtree of s1 or not
 */
public class CheckBinarySearchTreeIsSubTree {
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

    public static <T extends Comparable<T>> boolean isSubTree(Node<T> t1, Node<T> t2) {
        Node<T> headFound = search(t1, t2.value);
        if (headFound == null)
            return false;

        return compareTree(headFound, t2);
    }

    public static <T extends Comparable<T>> boolean compareTree(Node<T> node1, Node<T> node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null)
            return false;

        if (node2 == null)
            return false;

        if (node1.value.compareTo(node2.value) != 0)
            return false;

        return compareTree(node1.left, node2.left) && compareTree(node1.right, node2.right);
    }

    public static <T extends Comparable<T>> Node<T> search(Node<T> node, T value) {
        if (node == null)
            return null;

        int cmp = value.compareTo(node.value);
        if (cmp == 0) {
            // Found
            return node;
        }

        if (cmp < 0) {
            return search(node.left, value);
        }

        return search(node.right, value);
    }

    public static void main(String[] args) {
        Node<Integer> t1 = new Node<>(10);
        t1.left = new Node<>(7);
        t1.left.left = new Node<>(4);
        t1.left.right = new Node<>(8);
        t1.right = new Node<>(12);

        Node<Integer> t2 = new Node<>(7);
        t2.left = new Node<>(4);
        t2.right = new Node<>(8);
        t2.right.right = new Node<>(9);

        System.out.println(isSubTree(t1, t2));
    }
}