/**
 * Created by sky on 5/14/15.
 */
public class SumLinkedList {
    public static final class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static final class MyLinkedList {
        Node head;
        Node tail;
        int N;

        public MyLinkedList() {
            head = null;
            tail = null;
            N = 0;
        }

        public void insertTail(int value) {
            N++;

            if (head == null) {
                head = new Node(value);
                tail = head;
                return;
            }

            tail.next = new Node(value);
            tail = tail.next;
        }

        public Node list() {
            return head;
        }
    }

    public static Node sumLinkedList(Node a1, Node a2) {
        // 365 + 48
        if (a1 == null || a2 == null)
            throw new IllegalArgumentException("Invalid argument null");

        MyLinkedList myLinkedList = new MyLinkedList();

        int rest = 0;
        Node curr1 = a1;
        Node curr2 = a2;

        while (curr1 != null && curr2 != null) {
            int sum = curr1.value + curr2.value + rest;
            int mod = sum % 10;
            rest = sum / 10;

            myLinkedList.insertTail(mod);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int sum = curr1.value + rest;
            int mod = sum % 10;
            rest = sum / 10;

            myLinkedList.insertTail(mod);
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int sum = curr1.value + rest;
            int mod = sum % 10;
            rest = sum / 10;

            myLinkedList.insertTail(mod);
            curr2 = curr2.next;
        }

        if (rest > 0)
            myLinkedList.insertTail(rest);

        return myLinkedList.list();
    }

    public static void printValue(Node node) {
        if (node.next == null) {
            System.out.print(node.value);
            return;
        }

        printValue(node.next);
        System.out.print(node.value);
    }

    public static void main (String[] args) throws java.lang.Exception {
        // 365
        Node a1 = new Node(5);
        a1.next = new Node(6);
        a1.next.next = new Node(3);

        // 48
        Node a2 = new Node(8);
        a2.next = new Node(4);

        Node r = sumLinkedList(a1, a2);
        printValue(r); System.out.println();
    }
}
