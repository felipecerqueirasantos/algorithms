/**
 * Created by sky on 5/16/15.
 */
public class HeightBalanced {
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }


    public static <T extends Comparable<T>> boolean isHeightBalanced(Node<T> head) {
        return Math.abs(maxHeight(head.right, 1) - maxHeight(head.left, 1)) <= 1;
    }

    private static <T extends Comparable<T>> int maxHeight(Node<T> node, int height) {
        if (node == null) return height;

        return Math.max(maxHeight(node.left, height + 1),
                maxHeight(node.right, height + 1));
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(10);
        head.right = new Node<>(20);
        head.left = new Node<>(8);
        head.left.left = new Node<>(3);
        head.left.left.left = new Node<>(2);

        System.out.println(isHeightBalanced(head));
    }
}
