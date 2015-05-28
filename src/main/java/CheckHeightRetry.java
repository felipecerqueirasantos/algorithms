/**
 * Created by sky on 5/16/15.
 */
public class CheckHeightRetry {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean isBSTBalanced(Node<T> head) {
        return Math.abs(maxHeight(head.right, 1) - maxHeight(head.left, 1)) <= 1;
    }

    private static <T extends Comparable<T>> int maxHeight(Node<T> node, int height) {
        if (node == null)
            return height;

        return Math.max(maxHeight(node.left, height + 1),
                maxHeight(node.right, height + 1));
    }


    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);
        root.right = new Node<>(20);
        root.left = new Node<>(5);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(6);
        root.left.left.left = new Node<>(1);

        System.out.println(isBSTBalanced(root));
    }
}
