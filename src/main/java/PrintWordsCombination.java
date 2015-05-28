/**
 * Created by sky on 5/10/15.
 */
public class PrintWordsCombination {
    public static void recursivePrint(String[][] words) {
        recursivePrint(words, 0, "");
    }

    private static void recursivePrint(String[][] words, int layer, String s) {
        if (layer == words.length) {
            System.out.println(s);
            return;
        }

        for (int i = 0; i < words[layer].length; i++) {
            recursivePrint(words, layer + 1, s + words[layer][i] + " ");
        }
    }

    public static void main(String[] args) {
        String[][] words = new String[][] { {"you", "we"}, {"have", "are"}, {"sleep", "eat", "drink"}};
        recursivePrint(words);
    }
}