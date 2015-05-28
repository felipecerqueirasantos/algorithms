/**
 * Created by sky on 5/5/15 from Kaidul Islam algorithm
 */
public class RegularTreeInOrder {
    private static final class Node<T> {
        private T value;
        private Node<T> right;
        private Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T> void inorderWithConstantSpace(Node<T> root) {
        if (root == null)
            return;

        Node<T> current = root;

        while(current != null) {
            if(current.left != null) {
                Node<T> leftChild = current.left;
                Node<T> tmp = leftChild;
                Node<T> rightMost = null;

                while(leftChild != null) {
                    rightMost = leftChild;
                    leftChild = leftChild.right;
                }

                rightMost.right = current;
                current.left = null;
                current = tmp;
            } else {
                System.out.println(current.value);
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);
        root.right = new Node<>(9);
        root.right.right = new Node<>(6);
        root.right.left = new Node<>(7);

        root.left = new Node<>(12);
        root.left.right = new Node<>(17);
        root.left.left = new Node<>(14);

        inorderWithConstantSpace(root);
    }
}
