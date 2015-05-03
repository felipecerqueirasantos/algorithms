/**
 * Created by sky on 5/2/15.
 */
public class BinaryTreeLongestSequenceOfConsecutiveNumbers {
    private static final class Node<T extends Comparable<T>> {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
    }

        /*
                    1
                  9   6
                 3      3
                4         4
               5            9
              6
     */


    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.left = new Node<>(9);
        head.left.left = new Node<>(3);
        head.left.left.left = new Node<>(4);
        head.left.left.left.left = new Node<>(5);
        head.left.left.left.left.left = new Node<>(6);

        head.right = new Node<>(2);
        head.right.right = new Node<>(6);
        head.right.right.right = new Node<>(4);
        head.right.right.right.right = new Node<>(5);
        head.right.right.right.right.right = new Node<>(9);

        Dfs dfs = new Dfs(head);
        System.out.println(dfs.maxCounter);
    }

    private static class Dfs {
        private int maxCounter = 0;
        private int counter = 0;

        public Dfs(Node<Integer> head) {
            consecutiveSequence(head, null);
        }

        private void consecutiveSequence(Node<Integer> node, Node<Integer> parent) {

            if (node == null) return;

            if (parent != null) {
                System.out.println(parent.value + " -> " + node.value);
                if (node.value - parent.value != 1) {
                    maxCounter = Math.max(maxCounter, counter);
                    counter = 0;
                } else {
                    counter++;
                }
            }

            consecutiveSequence(node.left, node);
            consecutiveSequence(node.right, node);
        }
    }
}
