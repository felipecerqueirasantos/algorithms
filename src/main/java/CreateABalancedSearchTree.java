import java.util.*;

/**
 * Created by sky on 5/6/15.
 */
public class CreateABalancedSearchTree {
    // Nested class to represent a tree node
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node<>(value);

        if (value.compareTo(node.value) > 0)
            node.right = insert(node.right, value);
        else
            node.left = insert(node.left, value);

        return node;
    }

    public static <T extends Comparable<T>> boolean isBSTBalanced(Node<T> root) {
        return Math.abs(maxHeight(root.left, 1) - maxHeight(root.right, 1)) <= 1;
    }

    public static <T extends Comparable<T>> int maxHeight(Node<T> node, int height) {
        if (node == null) return height;

        return Math.max(maxHeight(node.left, height + 1),
                maxHeight(node.right, height + 1));
    }

    public static void binarySearch(int[] arr, int left, int right, List<Integer> list) {
        if (right < left) return;

        int mid = midPoint(left, right);
        list.add(arr[mid]);

        binarySearch(arr, mid + 1, right, list);
        binarySearch(arr, left, mid - 1, list);
    }

    private static int midPoint(int left, int right) {
        return left + (right - left) / 2;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 12, 8, 2, 7, 8};
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        binarySearch(arr, 0, arr.length - 1, list);

        Node<Integer> root = null;
        for (Integer i: list) {
            root = insert(root, i);
        }

        System.out.println(isBSTBalanced(root));
    }
}