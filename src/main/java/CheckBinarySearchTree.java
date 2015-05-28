/**
 * Created by sky on 5/6/15.
 */
/*
public class CheckBinarySearchTree {
    public static final class CharNode<T extends Comparable<T>> {
        private T value;
        private CharNode<T> right;
        private CharNode<T> left;

        public CharNode(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> CharNode<T> insertBinarySearchTree(CharNode<T> node, T value) {
        if (node == null) return new CharNode<>(value);

        if (value.compareTo(node.value) > 0) {
            node.right = insertBinarySearchTree(node.right, value);
        } else {
            node.left = insertBinarySearchTree(node.left, value);
        }

        return node;
    }

    public static <T extends Comparable<T>> boolean isBinarySearchTree(CharNode<T> root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static <T extends Comparable<T>> boolean isBinarySearchTree(CharNode<T> node, Integer min, Integer max) {
        if (node == null)
            return true;

        if (node.value.compareTo((T)min) <= 0 || node.value.compareTo((T)max) > 0) {
            return false;
        }

        if (isBinarySearchTree(node.left, min, (Integer) node.value) == false ||
                isBinarySearchTree(node.right, (Integer)node.value, max) == false) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CharNode<Integer> root = null;
        root = insertBinarySearchTree(root, 11);
        root = insertBinarySearchTree(root, 9);
        root = insertBinarySearchTree(root, 15);
        root = insertBinarySearchTree(root, 8);
        root = insertBinarySearchTree(root, 10);
        root = insertBinarySearchTree(root, 14);
        root = insertBinarySearchTree(root, 16);

        printBinarySearchTree(root);

        boolean ret = isBinarySearchTree(root);
        System.out.println(ret);

        CharNode<Integer> head = new CharNode<>(10);
        head.left = new CharNode<>(7);
        head.right = new CharNode<>(12);

        head.left.left = new CharNode<>(5);
        head.left.left.left = new CharNode<>(3);

        head.left.right = new CharNode<>(8);
        head.left.right.right = new CharNode<>(9);

        head.right.left = new CharNode<>(11);
        System.out.println(isBinarySearchTree(head));
    }

    private static <T extends Comparable<T>> void printBinarySearchTree(CharNode<T> node) {
        if (node == null) return;
        printBinarySearchTree(node.left);
        System.out.println(node.value);
        printBinarySearchTree(node.right);
    }
}*/

public class CheckBinarySearchTree {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean isBinarySearchTree(Node<T> root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static <T extends Comparable<T>> boolean isBinarySearchTree(Node<T> node, Integer min, Integer max) {
        if (node == null) return true;
        if (node.value.compareTo((T) min) <= 0 ||
                node.value.compareTo((T) max) > 0) {
            return false;
        }

        if (!isBinarySearchTree(node.left, min, (Integer) node.value) ||
                !isBinarySearchTree(node.right, (Integer) node.value, max)) {
            return false;
        }

        return true;
    }

    public static <T extends Comparable<T>> Node<T> insertBinarySearchTree(Node<T> node, T value) {
        if (node == null) return new Node<>(value);

        if (value.compareTo(node.value) > 0) {
            node.right = insertBinarySearchTree(node.right, value);
        } else {
            node.left = insertBinarySearchTree(node.left, value);
        }

        return node;
    }

    public static void main(String[] args) {
        Node<Integer> root = null;
        root = insertBinarySearchTree(root, 11);
        root = insertBinarySearchTree(root, 9);
        root = insertBinarySearchTree(root, 15);
        root = insertBinarySearchTree(root, 8);
        root = insertBinarySearchTree(root, 10);
        root = insertBinarySearchTree(root, 14);
        root = insertBinarySearchTree(root, 16);

        System.out.println(isBinarySearchTree(root));

        Node<Integer> head = new Node<>(8);
        head.left = new Node<>(6);
        head.left.left = new Node<>(3);
        head.left.right = new Node<>(7);
        System.out.println(isBinarySearchTree(head));
    }
}