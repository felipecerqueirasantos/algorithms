import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sky on 27/05/15.
 */
public class BinaryTreeFoldable {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean isFoldable(Node<T> root) {
        Queue<Node<T>> leftQueue = new ArrayDeque<>();
        Queue<Node<T>> rightQueue = new ArrayDeque<>();
        boolean ret = true;

        if (root.left != null)
            leftQueue.add(root.left);

        if (root.right != null)
            rightQueue.add(root.right);

        int totDiff = 0;
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            Node<T> left = leftQueue.remove();
            Node<T> right = rightQueue.remove();

            if (left.value.compareTo(right.value) != 0) {
                totDiff++;

                if (totDiff > 1) {
                    ret = false;
                    break;
                }
            }

            if (left.left != null)
                leftQueue.add(left.left);

            if (left.right != null)
                leftQueue.add(left.right);

            if (right.right != null)
                rightQueue.add(right.right);

            if (right.left != null)
                rightQueue.add(right.left);
        }

        if (leftQueue.size() != rightQueue.size())
            ret = false;

        return ret;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.left.left.left = new Node<>(6);
        root.left.left.right = new Node<>(7);

        root.left.right.left = new Node<>(8);
        root.left.right.right = new Node<>(9);

        root.right = new Node<>(3);
        root.right.right = new Node<>(4);
        root.right.left = new Node<>(5);
        root.right.right.left = new Node<>(7);
        root.right.right.right = new Node<>(6);
        root.right.left.left = new Node<>(9);
        root.right.left.right = new Node<>(8);

        System.out.println(isFoldable(root));
    }
}

