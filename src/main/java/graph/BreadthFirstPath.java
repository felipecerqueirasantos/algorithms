package graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sky on 4/8/15.
 */
public class BreadthFirstPath implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPath(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            for (int w: G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
