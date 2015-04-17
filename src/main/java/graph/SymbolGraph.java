package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 4/10/15.
 */
public class SymbolGraph {
    private Graph G;
    private Map<String, Integer> nameToIdMap;
    private Map<Integer, String> idToNameMap;
    private int id;

    public SymbolGraph(Graph G) {
        this.G = G;
        nameToIdMap = new HashMap<>();
        idToNameMap = new HashMap<>();
    }

    public void addEdge(String v, String w) {
        Integer idV = nameToIdMap.get(v);
        Integer idW = nameToIdMap.get(w);

        if (idV == null) {
            idV = id++;
            nameToIdMap.put(v, idV);
            idToNameMap.put(idV, v);
        }

        if (idW == null) {
            idW = id++;
            nameToIdMap.put(w, idW);
            idToNameMap.put(idW, w);
        }

        G.addEdge(idV, idW);
    }

    public boolean contains(String v) {
        return nameToIdMap.containsKey(v);
    }

    public Integer index(String v) {
        return nameToIdMap.get(v);
    }

    public String name(int v) {
        return idToNameMap.get(v);
    }

    public Iterable<String> adj(String v) {
        Integer idV = index(v);
        if (idV == null)
            return null;

        List<String> adj = new ArrayList<>();
        for (int w: G.adj(idV)) {
            String s = idToNameMap.get(w);

            if (s == null) {
                throw new IllegalStateException("Failed trying to lookup for a graph id name");
            }

            adj.add(s);
        }

        return adj;
    }
}
