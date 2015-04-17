package graph;

/**
 * Created by sky on 08/04/15.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(UndirectedGraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(UndirectedGraph G, int v) {
        marked[v] = true;
        count++;

        for (int w: G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    private boolean marked(int w) {
        return marked[w];
    }

    private int count() {
        return count;
    }
}
