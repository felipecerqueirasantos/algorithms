/**
 * Created by sky on 5/6/15.
 */
public class CheckBalancedSearchTreeHeight {
    // Nested class to represents a tree node
    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> boolean isBSTBalanced(Node<T> root) {
        return Math.abs(maxHeight(root.left, 1) - maxHeight(root.right, 1)) <= 1;
    }

    public static <T extends Comparable<T>> int maxHeight(Node<T> node, int height) {
        if (node == null) return height;

        return Math.max(maxHeight(node.left, height + 1),
                maxHeight(node.right, height + 1));
    }

    public static <T extends Comparable<T>> Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node<>(value);
        if (value.compareTo(node.value) > 0)
            node.right = insert(node.right, value);
        else
            node.left = insert(node.left, value);

        return node;
    }

    /*
                 10
           7           15
        5     9     12     20
       3 6   8

     */

    public static void main(String[] args) {
        Node<Integer> balancedTree = null;

        balancedTree = insert(balancedTree, 10);
        balancedTree = insert(balancedTree, 15);
        balancedTree = insert(balancedTree, 12);
        balancedTree = insert(balancedTree, 20);
        balancedTree = insert(balancedTree, 7);
        balancedTree = insert(balancedTree, 5);
        balancedTree = insert(balancedTree, 3);
        balancedTree = insert(balancedTree, 6);
        balancedTree = insert(balancedTree, 9);
        balancedTree = insert(balancedTree, 8);

        System.out.println(isBSTBalanced(balancedTree));

        Node<Integer> notBalancedTree = null;
        for (int i = 0; i < 10; i++)
            notBalancedTree = insert(notBalancedTree, i);

        System.out.println(isBSTBalanced(notBalancedTree));
    }
}