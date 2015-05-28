/**
 * Created by sky on 5/19/15.
 */
/*
6) Convert a BST to a sorted circular doubly-linked list in-place.
*/

public class ConvertBinarySearchTreeIntoCircularDoublyLinkedList {
    public static final class Node<T extends Comparable<T>> {
        private T value;

        // BST
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node<>(value);
        int cmp = value.compareTo(node.value);

        if (cmp > 0) {
            node.right = insert(node.right, value);
        } else {
            node.left = insert(node.left, value);
        }
        return node;
    }

    public static <T extends Comparable<T>> Node<T> inOrder(Node<T> root) {
        changeLeft(root, null);
        return changeRight(root);
    }

    public static <T extends Comparable<T>> void changeLeft(Node<T> node, Node<T> prev) {
        if (node == null) {
            return;
        }

        if (prev != null) {
            changeLeft(node.left, node);
            node.left = prev;
            changeLeft(node.right, node);
        }
    }

    public static <T extends Comparable<T>> Node<T> changeRight(Node<T> node) {
        Node<T> prev = null;
        while (node != null && node.right != null) {
            node = node.right;
        }

        while (node != null && node.left != null) {
            prev = node;
            node = node.left;
            node.right = prev;
        }

        return node;
    }
        /*
                26
           18         39
        16    22   28    42

         */

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[]{26, 18, 39, 16, 22, 28, 42};
        Node<Integer> root = null;

        for (int i = 0; i < arr.length;  i++) {
            root = insert(root, arr[i]);
        }

        root = inOrder(root);

        Node<Integer> curr = root;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.left;

            Thread.sleep(500);
        }

    }
}