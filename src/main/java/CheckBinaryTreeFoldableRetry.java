import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sky on 04/06/15.
 */
public class CheckBinaryTreeFoldableRetry {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean isFoldable(Node<T> tree) {
        if (tree == null)
            return true;

        if (tree.left == null && tree.right == null)
            return true;

        if (tree.left == null || tree.right == null)
            return false;

        return isFoldable(tree.left, tree.right);
    }

	/*
                     5
                  1        2
               3    4    4   3
              6 7  8 9  9 8 7 6

     */

    private static <T extends Comparable<T>> void insertQueue(Node<T> left,
                                                              Node<T> right,
                                                              Queue<Node<T>> leftQueue,
                                                              Queue<Node<T>> rightQueue) {

        if (left.left != null)
            leftQueue.add(left.left);

        if (left.right != null)
            leftQueue.add(left.right);

        if (right.right != null)
            rightQueue.add(right.right);

        if (right.left != null)
            rightQueue.add(right.left);
    }

    private static <T extends Comparable<T>> boolean isFoldable(Node<T> left, Node<T> right) {
        boolean ret = true;
        Queue<Node<T>> leftQueue = new ArrayDeque<>();
        Queue<Node<T>> rightQueue = new ArrayDeque<>();

        insertQueue(left, right, leftQueue, rightQueue);

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            Node<T> L = leftQueue.remove();
            Node<T> R = rightQueue.remove();

            if (L.value.compareTo(R.value) != 0) {
                ret = false;
                break;
            }

            insertQueue(L, R, leftQueue, rightQueue);
        }

        if (!ret)
            return ret;

        if (leftQueue.size() != rightQueue.size())
            ret = false;

        return ret;
    }

    public static void main (String[] args) throws java.lang.Exception {
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
