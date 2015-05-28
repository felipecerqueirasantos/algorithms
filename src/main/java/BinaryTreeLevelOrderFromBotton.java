import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sky on 5/16/15.
 */
public class BinaryTreeLevelOrderFromBotton {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }
/*

         26
        /   \
      10     3
    /    \     \
  4      6      3

 */
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(26);
        root.left = new Node<>(10);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(6);
        root.right = new Node<>(3);
        root.right.right = new Node<>(3);

        levelOrderFromBottom(root);
    }

    private static <T extends Comparable<T>> void levelOrderFromBottom(Node<T> root) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        Stack<Node<T>> stack = new Stack<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> t = queue.remove();
            stack.push(t);
            if (t.right != null) queue.add(t.right);
            if (t.left != null) queue.add(t.left);
        }

        while (!stack.isEmpty()) {
            Node<T> t = stack.pop();
            System.out.println(t.value);
        }
    }

}
