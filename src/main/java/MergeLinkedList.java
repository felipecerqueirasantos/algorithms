/**
 * Created by sky on 4/8/15.
 */
public class MergeLinkedList {
    private static class Node<T extends Comparable<T>> {
        private Node<T> next;
        private T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public static <T extends Comparable<T>> void printList(Node<T> head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> list1 = new Node<>(10);
        list1.next = new Node<>(11);

        Node<Integer> list2 = new Node<>(8);
        list2.next = new Node<>(9);
        list2.next.next = new Node<>(12);

        Node<Integer> merged = mergeList(list1, list2);
        printList(merged);
    }

    private static <T extends Comparable<T>> Node<T> mergeList(Node<T> list1, Node<T> list2) {
        Node<T> merged;
        Node<T> ref;

        if (list1.value.compareTo(list2.value) < 0) {
            // list1 is smaller
            merged = new Node<>(list1.value);
            list1 = list1.next;
        } else {
            // list2 is smaller
            merged = new Node<>(list2.value);
            list2 = list2.next;
        }

        ref = merged;

        while (list1 != null && list2 != null) {
            if (list1.value.compareTo(list2.value) < 0) {
                ref.next = new Node<>(list1.value);
                list1 = list1.next;
            } else {
                ref.next = new Node<>(list2.value);
                list2 = list2.next;
            }
            ref = ref.next;
        }

        while (list1 != null) {
            ref.next = new Node<>(list1.value);
            ref = ref.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            ref.next = new Node<>(list2.value);
            ref = ref.next;
            list2 = list2.next;
        }

        return merged;
    }
}