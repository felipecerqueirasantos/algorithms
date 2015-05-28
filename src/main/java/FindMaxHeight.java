/**
 * Created by sky on 5/27/15.
 */
public class FindMaxHeight {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> int findMaxHeight(Node<T> node) {
        return Math.max(findMaxHeight(node.right, 1),
                findMaxHeight(node.left, 1));
    }

    private static <T extends Comparable<T>> int findMaxHeight(Node<T> node, int height) {
        if (node == null)
            return height;
        return Math.max(findMaxHeight(node.right, height + 1), findMaxHeight(node.left, height + 1));
    }

    public static <T extends Comparable<T>> Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node<>(value);

        int cmp = value.compareTo(node.value);
        if (cmp >= 0) node.right = insert(node.right, value);
        else node.left = insert(node.left, value);

        return node;
    }

    public static void main(String[] args) {
        Node<Integer> root = null;

        for (int i = 0; i < 100; i++)
            root = insert(root, i);

        System.out.println(findMaxHeight(root));
    }
}
