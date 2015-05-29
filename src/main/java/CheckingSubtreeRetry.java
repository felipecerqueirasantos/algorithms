/**
 * Created by sky on 5/28/15.
 */
public class CheckingSubtreeRetry {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean checkSubstree(Node<T> node, Node<T> sub) {
        if (node == null || sub == null)
            return false;

        if (node.value.compareTo(sub.value) == 0) {
            if (dfs(node, sub))
                return true;
        }

        boolean right = checkSubstree(node.right, sub);
        boolean left = checkSubstree(node.left, sub);

        return (right || left);
    }

    private static <T extends Comparable<T>> boolean dfs(Node<T> node, Node<T> sub) {
        if (node == null && sub == null)
            return true;

        if (node == null || sub == null)
            return false;

        if (node.value.compareTo(sub.value) != 0)
            return false;

        return dfs(node.right, sub.right) && dfs(node.left, sub.left);
    }

    public static void main(String[] args) {
        Node<Integer> t1 = new Node<>(10);
        t1.left = new Node<>(11);
        t1.right = new Node<>(12);
        t1.right.right = new Node<>(13);

        Node<Integer> t2 = new Node<>(12);
        t2.right = new Node<>(13);


        System.out.println(checkSubstree(t1, t2));
    }
}
