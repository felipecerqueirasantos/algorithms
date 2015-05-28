/**
 * Created by sky on 5/16/15.
 */
public class BinaryTreePathSum {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static boolean checkSumPath(Node<Integer> root, int needed) {
        if (checkSumPath(root.left, needed, root.value) || checkSumPath(root.right, needed, root.value)) {
            return true;
        }
        return false;
    }

    private static boolean checkSumPath(Node<Integer> node, int needed, int acc) {
        if (node == null) {
            if (acc == needed)
                return true;
            return false;
        }

        if (checkSumPath(node.left, needed, acc + node.value) || checkSumPath(node.right, needed, acc + node.value)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Node<Integer> tree = new Node<>(26);
        tree.right = new Node<>(3);
        tree.right.right = new Node<>(3);

        tree.left = new Node<>(10);
        tree.left.right = new Node<>(6);
        tree.left.left = new Node<>(4);
        tree.left.left.right = new Node<>(30);

        Node<Integer> subTree = new Node<>(10);
        subTree.right = new Node<>(6);
        subTree.left = new Node<>(4);
        subTree.left.right = new Node<>(30);

        System.out.println(checkSumPath(tree, 33));
        System.out.println(checkSumPath(tree, 32));
        System.out.println(checkSumPath(tree, 42));
        System.out.println(checkSumPath(tree, 70));
        System.out.println(checkSumPath(tree, 5));
    }
}
