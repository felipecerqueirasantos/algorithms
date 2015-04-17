package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sky on 4/10/15.
 */
public class DirectedGraph implements Graph {
    private final int V;
    private int E;

    private List<List<Integer>> adj;

    public DirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public DirectedGraph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();

        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();

            addEdge(v, w);
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    public DirectedGraph reverse() {
        DirectedGraph R = new DirectedGraph(V);
        for (int v = 0; v < V; v++) {
            for (int w: adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(V).append(" vertices, ").append(E).append(" edges\n");
        for (int v = 0; v < V; v++)
        {
            sb.append(v).append(": ");

            for (int w : this.adj(v))
                sb.append(w).append(" ");

            sb.append("\n");
        }
        return sb.toString();
    }
}
