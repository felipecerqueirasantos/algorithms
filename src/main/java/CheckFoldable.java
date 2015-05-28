import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sky on 5/10/15.
 */
public class CheckFoldable {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    /* Testing:
                  1
              2       3
            4   5   5   4
           6 7 8 9 9 8 7 6

         leftDeque 2
         leftDeque 54
         leftDeque 765
         leftDeque 9876

         rightDeque 3
         rightDeque 54
         rightDeque 765
         rightDeque 9876

     */
    public static <T extends Comparable<T>> boolean isFoldable(Node<T> root) {
        Queue<Node<T>> leftDeque = new ArrayDeque<>();
        Queue<Node<T>> rightDeque = new ArrayDeque<>();

        boolean result = true;

        int totDiffs = 0;

        rightDeque.add(root.right);
        leftDeque.add(root.left);

        while (!rightDeque.isEmpty() || !leftDeque.isEmpty()) {
            Node<T> R = rightDeque.remove();
            Node<T> L = leftDeque.remove();

            if (R.value.compareTo(L.value) != 0) {
                totDiffs++;
                if (totDiffs > 1) {
                    result = false;
                    break;
                }
            }

            if (L.left  != null) leftDeque.add(L.left);
            if (L.right != null) leftDeque.add(L.right);

            if (R.right != null) rightDeque.add(R.right);
            if (R.left  != null) rightDeque.add(R.left);
        }

        if (rightDeque.size() != leftDeque.size())
            return false;

        return result;
    }

    /* Testing:
                  1
              2       3
            4   5   5   4
           6 7 8 9 9 8 7 6
     */
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