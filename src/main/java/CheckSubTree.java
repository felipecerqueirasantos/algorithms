/**
 * Created by sky on 5/16/15.
 */
public class CheckSubTree {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean isSubTree(Node<T> tree, Node<T> subTree) {
        if (subTree == null)
            return true;

        if (tree == null)
            return false;

        if (compareSubTree(tree, subTree)) {
            return true;
        }

        return isSubTree(tree.left, subTree) || isSubTree(tree.right, subTree);
    }

    private static <T extends Comparable<T>> boolean compareSubTree(Node<T> tree, Node<T> subTree) {
        if (subTree == null && tree == null)
            return true;

        if (tree == null || subTree == null)
            return false;

        if (tree.value.compareTo(subTree.value) == 0) {
            return compareSubTree(tree.left, subTree.left) && compareSubTree(tree.right, subTree.right);
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

        System.out.println(isSubTree(tree, subTree));
    }
}
