/**
 * Created by sky on 5/6/15.
 */
public class CustomTypeComparable {
    private static abstract class MinMaxCustomType implements Comparable<MinMaxCustomType> {
        public abstract MinMaxCustomType getMin();
        public abstract MinMaxCustomType getMax();
    }

    public static final class Node<T extends MinMaxCustomType> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    private static final class CrazyValue<T extends Comparable<T>> extends MinMaxCustomType {
        private static final int MAX = Integer.MAX_VALUE;
        private static final int MIN = Integer.MIN_VALUE;

        private int value;

        public CrazyValue(int value) {
            this.value = value;
        }

        @Override
        public MinMaxCustomType getMin() {
            return new CrazyValue(MIN);
        }

        @Override
        public MinMaxCustomType getMax() {
            return new CrazyValue(MAX);
        }

        @Override
        public int compareTo(MinMaxCustomType o) {
            return 0;
        }
    }

    public static <T extends MinMaxCustomType> boolean checkBinarySearchTree(Node<T> root) {
        return  checkBinarySearchTree(root, root.value.getMin(), root.value.getMax());
    }

    public static <T extends MinMaxCustomType> boolean checkBinarySearchTree(Node<T> node, MinMaxCustomType min,
                                                                                MinMaxCustomType max) {
        if (node == null) return true;
        if (node.value.compareTo(min) <= 0 || node.value.compareTo(max) > 0)
            return false;

        if (!checkBinarySearchTree(node.right, node.value, max) ||
                !checkBinarySearchTree(node.left, min, node.value))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Node<CrazyValue<Integer>> root = new Node<CrazyValue<Integer>>(new CrazyValue<Integer>(10));

    }
}
