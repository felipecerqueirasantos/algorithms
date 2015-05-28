/**
 * Created by sky on 5/7/15.
 */
public class LowestCommonAncestorRetry {
    public static final class Node<T extends Comparable<T>> {
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

        boolean rightFound = binarySearch(node.right, a, b);
        boolean leftFound = binarySearch(node.left, a, b);

        if (rightFound && leftFound)
            return node;

        if (rightFound)
            return findLCA(node.right, a, b);

        return findLCA(node.left, a, b);
    }

    public static <T extends Comparable<T>> boolean binarySearch(Node<T> node, T a, T b) {
        if (node == null)
            return false;

        if (a.compareTo(node.value) == 0 || b.compareTo(node.value) == 0)
            return true;

        return binarySearch(node.left, a, b) || binarySearch(node.right, a, b);
    }

    /*
             15
           6    10
              8   13
     */


    public static <T extends Comparable<T>> Node<T> LCA(Node<T> node, T a, T b) {
        if (node == null) return null;

        boolean foundLeft = dfs(node.left, a, b);
        boolean foundRight = dfs(node.right, a, b);

        if (!foundLeft && !foundRight)
            return null;

        if (foundLeft && foundRight)
            return node;

        if (foundRight)
            return LCA(node.right, a, b);

        return LCA(node.left, a, b);
    }

    public static <T extends Comparable<T>> boolean dfs(Node<T>node, T a, T b) {
        if (node == null)
            return false;

        if (node.value.compareTo(a) == 0)
            return true;

        if (node.value.compareTo(b) == 0)
            return true;


        return dfs(node.left, a, b) || dfs(node.right, a, b);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(5);
        root.right = new Node<>(4);
        root.right.right = new Node<>(8);
        root.right.left = new Node<>(9);

        Node<Integer> common = LCA(root, 8, 9);
        if (common != null) {
            System.out.println(common);
        }
    }
}