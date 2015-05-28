/**
 * Created by sky on 06/05/15.
 */
/*
                        1
                    2       4
                 3     5  9   8

                 LCA(2, 4) = 1
                 LCA(3, 5) = 2
 */

public class LowestCommonAncestor {
    // Nested class to represent a Tree
    private static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }

    public static <T extends Comparable<T>> Node<T> findLCA(Node<T> node, T a, T b) {
        if (node == null) return null;

        boolean foundRight = dfs(node.right, a, b);
        boolean foundLeft = dfs(node.left, a, b);
        if (foundRight == true && foundLeft == true) return node;

        if (foundRight == true) return findLCA(node.right, a, b);
        return findLCA(node.left, a, b);
    }

    public static <T extends Comparable<T>> boolean dfs(Node<T> node, T a, T b) {
        if (node == null) return false;
        if (node.value.compareTo(a) == 0 || node.value.compareTo(b) == 0) return true;
        return dfs(node.right, a, b) || dfs(node.left, a, b);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(5);
        root.right = new Node<>(4);
        root.right.right = new Node<>(8);
        root.right.left = new Node<>(9);

        Node<Integer> common = findLCA(root, 3, 5);
        if (common != null) {
            System.out.println(common);
        }
    }
}