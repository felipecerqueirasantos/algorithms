import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sky on 01/06/15.
 */
public class CheckingConnectivity {
    public class Dag {
        private List<List<Integer>> adj;
        private int V;

        public Dag(int V) {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        public void add(int v, int w) {
            adj.get(v).add(w);
        }

        public int V() {
            return V;
        }

        public Iterable<Integer> adj(int e) {
            return adj.get(e);
        }
    }

    public class Dfs {
        private Dag G;
        private int s;
        private boolean[] marked;

        public Dfs(Dag G, int s) {
            this.G = G;
            this.s = s;

            this.marked = new boolean[G.V];

            dfs(s);
        }

        private void dfs(int v) {
            if (marked[v])
                return;

            marked[v] = true;

            for(Integer adj: G.adj(v)) {
                dfs(adj);
            }
        }

        public boolean hasPathTo(int w) {
            return marked[w];
        }

        public Iterator<Integer> pathTo(int w) {
            return null;
        }
    }

    private void testIt() {
        Dag dag = new Dag(10);
        dag.add(0, 1);
        dag.add(0, 2);
        dag.add(0, 3);
        dag.add(3, 4);
        dag.add(3, 5);
        dag.add(3, 7);
        dag.add(2, 7);
        dag.add(7, 8);
        dag.add(7, 9);
        dag.add(7, 6);

        Dfs dfs1 = new Dfs(dag, 0);
        System.out.println(dfs1.hasPathTo(5));

        Dfs dfs2 = new Dfs(dag, 7);
        System.out.println(dfs2.hasPathTo(0));
    }

    public static void main(String[] args) {
        new CheckingConnectivity().testIt();
    }

}
