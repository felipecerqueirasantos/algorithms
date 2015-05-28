import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 5/16/15.
 */
public class Trie {
    public static final class Node {
        private Map<Character, Node> map;
        private boolean eos;

        public Node() {
            map = new HashMap<>();
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void addWord(String s) {
        Node curr = root;

        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            Node next = curr.map.get(chr);

            if (next == null) {
                Node tmp = new Node();
                curr.map.put(chr, tmp);
                curr = tmp;
            } else {
                curr = next;
            }
        }

        curr.eos = true;
    }

    public boolean hasWord(String word) {
        boolean found = true;

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            Character chr = word.charAt(i);
            Node t = curr.map.get(chr);
            if (t == null) {
                found = false;
                break;
            }

            curr = t;
        }

        if (found && curr != null && !curr.eos)
            found = false;

        return found;
    }

    public void dumpTrie() {
        dumpTrie(root);
    }

    private void dumpTrie(Node node) {
        for (Character chr: node.map.keySet()) {
            System.out.println(chr);
            dumpTrie(node.map.get(chr));
        }
    }
}
