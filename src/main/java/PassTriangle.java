/**
 * Class to resolve code eval 89
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sky on 10/02/15.
 */
public class PassTriangle<E extends Comparable<E>> {

    /**
     * Class to represent a tree node
     */
    private static final class Node<E extends Comparable<E>> {
        private Node<E> left = null;
        private Node<E> right = null;
        private int maxSum = 0;
        private E v;

        public Node(E v) {
            this.v = v;
        }

        public void updateMaxSum(int sum) {
            if (sum > this.maxSum) {
                maxSum = sum;
            }
        }
    }

    public static void bfs(Node<Integer> root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node<Integer> n = queue.remove();
            System.out.println(n.v);
            if (n.left != null)  queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    public static int dfsMaxSum(Node<Integer> root) {
        return dfsMaxSum(root, 0);
    }

    public static int dfsMaxSum(Node<Integer> node, int sum) {
        if (node == null) return sum;
        int maxRight = dfsMaxSum(node.right, node.v + sum);
        int maxLeft = dfsMaxSum(node.left, node.v + sum);
        return Math.max(maxRight, maxLeft);
    }

    public static void main(String[] args) throws Exception {
        Node<Integer> root;

        BufferedReader br;
        Reader in;

        if (args.length == 0) {
            in = new InputStreamReader(System.in);
        } else {
            in = new FileReader(args[0]);
        }

        br = new BufferedReader(in);

        Queue<Node<Integer>> queue = new ArrayDeque<>();

        String line;
        line = br.readLine();

        root = new Node<>(Integer.parseInt(line.trim()));
        root.updateMaxSum(root.v);

        queue.add(root);

        while((line = br.readLine()) != null) {
            String[] tmp = line.split(" ");

            int[] a = new int[tmp.length];

            for (int i = 0; i < tmp.length; i++) {
                a[i] = Integer.parseInt(tmp[i]);
            }

            Node<Integer> node = null;
            for (int i = 0; i < a.length; i++) {
                if (node == null) {
                    node = queue.remove();
                }

                if (node.right != null) {
                    Node<Integer> nextNodeInline = queue.remove();
                    node.right.updateMaxSum(nextNodeInline.maxSum + node.right.v);

                    nextNodeInline.left = node.right;
                    node = nextNodeInline;
                }

                if (node.left == null) {
                    Node<Integer> newNode = new Node<>(a[i]);
                    newNode.updateMaxSum(node.maxSum + newNode.v);

                    node.left = newNode;
                    queue.add(newNode);
                } else if (node.right == null) {
                    Node<Integer> newNode = new Node<>(a[i]);
                    newNode.updateMaxSum(node.maxSum + newNode.v);

                    node.right = newNode;
                    queue.add(newNode);
                }
            }
        }

        br.close();

        // Retrieving maxSum from the bottom of the tree
        int max = 0;
        while (!queue.isEmpty()) {
            Node<Integer> n = queue.remove();
            if (n.maxSum > max) max = n.maxSum;
        }


        System.out.println(max);
    }
}
