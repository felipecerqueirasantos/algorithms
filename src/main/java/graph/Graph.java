package graph;

/**
 * Created by sky on 4/10/15.
 */
public interface Graph {
    int V();
    int E();
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
}
