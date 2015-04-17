package graph;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 4/10/15.
 */
public class SymbolGraphTest extends TestCase {
    public void test() throws Exception {
        Graph undirectedGraph = new UndirectedGraph(4);
        SymbolGraph lookupSymbol = new SymbolGraph(undirectedGraph);

        lookupSymbol.addEdge("FELIPE", "LARISSA");
        lookupSymbol.addEdge("LARISSA", "BRENO");
        lookupSymbol.addEdge("BRENO", "JULIETA");
        lookupSymbol.addEdge("JULIETA", "FELIPE");
        lookupSymbol.addEdge("JULIETA", "LARISSA");

        List<String> list = new ArrayList<>();
        for (String s: lookupSymbol.adj("JULIETA")) {
            list.add(s);
        }
        assertEquals(list.size(), 3);

        DepthFirstPath dfs = new DepthFirstPath(undirectedGraph, lookupSymbol.index("FELIPE"));
        boolean ret = dfs.hasPathTo(lookupSymbol.index("JULIETA"));
        assertEquals(ret, true);

        assertEquals(lookupSymbol.contains("FELIPE"), true);
        assertEquals(lookupSymbol.contains("LARISSA"), true);
        assertEquals(lookupSymbol.contains("BRENO"), true);
        assertEquals(lookupSymbol.contains("JULIETA"), true);
        assertEquals(lookupSymbol.contains("UNKOWN"), false);
    }
}