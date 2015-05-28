/**
 * Created by sky on 5/16/15.
 */
public class CheckSumTree {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static boolean isSumTree(Node<Integer> node) {
        if (node == null || (node.left == null && node.right == null))
            return true;

        int sumRight = sum(node.right);
        int sumLeft = sum(node.left);

        if (node.value != sumLeft + sumRight)
            return false;

        if (isSumTree(node.right) && isSumTree(node.left))
            return true;

        return false;
    }

    public static int sum(Node<Integer> node) {
        if (node == null)
            return 0;
        return sum(node.right) + node.value + sum(node.left);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(26);
        root.left = new Node<>(10);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(6);
        root.right = new Node<>(3);
        root.right.right = new Node<>(3);

        System.out.println(isSumTree(root));
    }
}
