/**
 * Created by sky on 5/18/15.
 */
public class LinkedListPalindrome {
    public static final class CharNode {
        private char chr;
        private CharNode next;

        public CharNode(char chr) {
            this.chr = chr;
        }
    }

    public static boolean isPalindrome(CharNode head) {
        CharNode fast;
        CharNode slow;

        slow = head;
        fast = head;

        char mask = 0;


        while (fast.next != null) {
            mask ^= slow.chr;

            fast = fast.next.next;
            slow = slow.next;
        }

        CharNode middle = slow;

        while (slow != null) {
            mask ^= slow.chr;
            slow = slow.next;
        }

        if (mask == 0)
            return true;

        if (mask != 0 && mask == middle.chr)
            return true;

        return false;
    }

    public static void main(String[] args) {
        CharNode head = new CharNode('a');
        head.next = new CharNode('b');
        head.next.next = new CharNode('a');
        System.out.println(isPalindrome(head));
    }
}
