import junit.framework.TestCase;

/**
 * Created by sky on 5/24/15.
 */
public class TrieTest extends TestCase {
    private Trie trie;

    public void setUp() throws Exception {
        super.setUp();
        trie = new Trie();
    }

    public void testTrie() throws Exception {
        trie.addWord("abcd");
        trie.addWord("abcde");
        trie.addWord("felipe");
        assertEquals(trie.hasWord("abcd"), true);
        assertEquals(trie.hasWord("abcde"), true);
        assertEquals(trie.hasWord("ab"), false);
        assertEquals(trie.hasWord("felipe"), true);
        assertEquals(trie.hasWord("felipes"), false);
        assertEquals(trie.hasWord("felips"), false);
    }

}