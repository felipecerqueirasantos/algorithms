/**
 * Created by sky on 5/11/15.
 */
public class MergeSortedLinkedList {

    public static final class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    // Merge a sorted linked list
    public static <T extends Comparable<T>> Node<T> mergeLinkedList(Node<T> list1, Node<T> list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node<T> newHead;

        int cmp = list1.value.compareTo(list2.value);
        if (cmp < 0) {
            newHead = new Node<T>(list1.value);
            list1 = list1.next;
        } else {
            newHead = new Node<T>(list2.value);
            list2 = list2.next;
        }

        // 1 .2 .3
        // .4 .5 .6
        Node<T> current = newHead;

        while (list1 != null && list2 != null) {
            cmp = list1.value.compareTo(list2.value);
            if (cmp < 0) {
                current.next = new Node<T>(list1.value);
                list1 = list1.next;
            } else {
                current.next = new Node<T>(list2.value);
                list2 = list2.next;
            }

            current = current.next;
        }

        while (list1 != null) {
            current.next = new Node<T>(list1.value);
            list1 = list1.next;
            current = current.next;
        }

        while (list2 != null) {
            current.next = new Node<T>(list2.value);
            list2 = list2.next;
            current = current.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node<Integer> l1 = new Node<>(1);
        l1.next = new Node<>(3);
        l1.next.next = new Node<>(6);

        Node<Integer> l2 = new Node<>(2);
        l2.next = new Node<>(4);
        l2.next.next = new Node<>(5);
        l2.next.next.next = new Node<>(10);

        Node<Integer> res = mergeLinkedList(l1, l2);
        Node<Integer> current = res;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}

