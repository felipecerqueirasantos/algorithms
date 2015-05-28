import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 5/16/15.
 */
public class CreatePathArrayBinarySearchTree {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> List<T> searchPath(Node<T> root, T key) {
        List<T> l = new ArrayList<>();
        return search(root, key, l);
    }

    private static <T extends Comparable<T>> List<T> search(Node<T> node, T key, List<T> path) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.value);
        if (cmp == 0) {
            path.add(node.value);
            return path;
        }

        if (cmp > 0) {
            List<T> t = new ArrayList<>(path.size() + 1);
            t.addAll(path);
            t.add(node.value);
            return search(node.right, key, t);
        } else {
            List<T> t = new ArrayList<>(path.size() + 1);
            t.addAll(path);
            t.add(node.value);
            return search(node.left, key, t);
        }
    }

    /*
         26
        /   \
      10     30
    /    \     \
  4      11      33
     */

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(26);
        root.left = new Node<>(10);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(11);
        root.right = new Node<>(30);
        root.right.right = new Node<>(33);

        List<Integer> l = searchPath(root, 33);
        if (l != null) {
            for(Integer i: l)
                System.out.println(i);
        }
    }
}
