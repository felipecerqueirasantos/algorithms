/**
 * Created by sky on 5/27/15.
 */
public class CheckingSubstree {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean isSubTree(Node<T> node, Node<T> sub) {

        boolean right = false;
        boolean left = false;

        if (node.value.compareTo(sub.value) == 0) {
            return dfs(node, sub);
        }

        if (node.left != null)
            left = isSubTree(node.left, sub);

        if (node.right != null)
            right = isSubTree(node.right, sub);

        if (left || right)
            return true;

        return false;
    }

    private static <T extends Comparable<T>> boolean dfs(Node<T> node, Node<T> sub) {
        if (node == null && sub == null)
            return true;

        if (node == null || sub == null)
            return false;

        if (node.value.compareTo(sub.value) == 0) {
            return dfs(node.right, sub.right) && dfs(node.left, sub.left);
        }

        return false;
    }

    public static void main(String[] args) {
        Node<Integer> t1 = new Node<>(10);
        t1.left = new Node<>(11);
        t1.right = new Node<>(12);
        t1.right.right = new Node<>(13);

        Node<Integer> t2 = new Node<>(12);
        t2.right = new Node<>(13);


        System.out.println(isSubTree(t1, t2));
    }

}
