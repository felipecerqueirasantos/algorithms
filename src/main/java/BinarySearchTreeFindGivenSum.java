/**
 * Created by sky on 5/16/15.
 */
public class BinarySearchTreeFindGivenSum {
    // Nested class to represent a CharNode of a tree
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void hasSum(Node<Integer> head) {
    }

    public static Integer sum(Node<Integer> node) {
        if (node.right == null && node.left == null)
            return node.value;

        int sumRight = 0;
        int sumLeft = 0;

        if (node.right != null) {
            int t = sum(node.right);
            sumRight += t;
            System.out.println("t = " + t);
            System.out.println("sumRight = " + sumRight);
        }

        if (node.left != null) {
            int t = sum(node.left);
            sumLeft += t;
            System.out.println("t = " + t);
            System.out.println("sumLeft = " + sumLeft);
        }


        System.out.println(node.value);
        System.out.println(node.value + sumRight);
        System.out.println(node.value + sumLeft);
        System.out.println(sumLeft + sumRight);
        System.out.println(node.value + sumLeft + sumRight);

        return node.value + sumRight + sumLeft;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(4);
        head.left = new Node<>(3);
        head.left.left = new Node<>(2);
        head.right = new Node<>(5);

        sum(head);
    }
}
