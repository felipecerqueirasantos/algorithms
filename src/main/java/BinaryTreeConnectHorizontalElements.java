import java.util.*;

/**
 * Created by sky on 5/2/15.
 */
public class BinaryTreeConnectHorizontalElements {
    private static final class BstNode<T extends Comparable<T>> {
        private T value;
        private BstNode<T> left;
        private BstNode<T> right;

        public BstNode(T value) {
            this.value = value;
        }
    }

    private static final class LList<T> implements Iterable<T> {
        private static final class ListNode<T> {
            private T value;
            private ListNode next;

            public ListNode(T value) {
                this.value = value;
            }
        }

        private int N;
        private ListNode<T> head;
        private ListNode<T> tail;

        public LList() {

        }

        public void add(T value) {
            if (head == null) {
                head = new ListNode<>(value);
                tail = head;
                N++;
                return;
            }

            tail.next = new ListNode<>(value);
            tail = tail.next;
            N++;
        }

        public int size() {
            return N;
        }

        @Override
        public Iterator<T> iterator() {
            return new Itr();
        }

        private final class Itr implements Iterator<T> {
            private ListNode<T> cursor = head;
            private int left = N;

            @Override
            public boolean hasNext() {
                return left > 0;
            }

            @Override
            public T next() {
                left--;
                T val = cursor.value;
                cursor = cursor.next;
                return val;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            ListNode<T> p = head;

            while (p != null) {
                if (i > 0) sb.append(" -> ");
                sb.append(p.value);
                p = p.next;
                i++;
            }

            sb.append(" -> null");
            return sb.toString();
        }
    }

    /*
             10
           6    17
         4    14  19
     */

    private static BstNode<Integer> insertBinarySearchTree(BstNode<Integer> bstNode, Integer value) {
        if (bstNode == null) return new BstNode<>(value);

        if (bstNode.value.compareTo(value) > 0) {
            bstNode.left = insertBinarySearchTree(bstNode.left, value);
        } else {
            bstNode.right = insertBinarySearchTree(bstNode.right, value);
        }

        return bstNode;
    }

    private static void dfsInOrder(BstNode<Integer> bstNode) {
        if (bstNode == null) return;
        dfsInOrder(bstNode.left);
        System.out.println(bstNode.value);
        dfsInOrder(bstNode.right);
    }

    private static void bfs(BstNode<Integer> bstNode) {
        Queue<BstNode> queue = new ArrayDeque<>();

        LList<LList<Integer>> savedList = new LList<>();
        LList<Integer> list = new LList<>();

        int nodesInCurrentLevel = 1;
        int nodesInNextLevel = 0;

        queue.add(bstNode);
        while(!queue.isEmpty()) {
            BstNode<Integer> n = queue.remove();
            //System.out.println(n.value);

            list.add(n.value);

            nodesInCurrentLevel--;

            if (n.left != null) {
                queue.add(n.left);
                nodesInNextLevel++;
            }

            if (n.right != null) {
                queue.add(n.right);
                nodesInNextLevel++;
            }

            if (nodesInCurrentLevel == 0) {
                savedList.add(list);
                list = new LList<>();

                nodesInCurrentLevel = nodesInNextLevel;
                nodesInNextLevel = 0;
            }
        }

        for (LList<Integer> s: savedList) {
            System.out.println(s);
        }
    }

    public void run() {
        BstNode<Integer> root = null;
        root = insertBinarySearchTree(root, 10);
        root = insertBinarySearchTree(root, 6);
        root = insertBinarySearchTree(root, 4);
        root = insertBinarySearchTree(root, 17);
        root = insertBinarySearchTree(root, 14);
        root = insertBinarySearchTree(root, 19);

        //dfsInOrder(root);
        bfs(root);

    }

    public static void main(String[] args) {
        new BinaryTreeConnectHorizontalElements().run();
    }
}
