package graph;

import junit.framework.TestCase;

import java.util.Scanner;

/**
 * Created by sky on 07/04/15.
 */
public class UndirectedGraphTest extends TestCase {

    public void testDfs() throws Exception {
        StringBuilder sb  = new StringBuilder();
        sb.append("8").append("\n"); // Vertices
        sb.append("7").append("\n"); // Edges
        sb.append("0").append(" ").append("1").append("\n");
        sb.append("1").append(" ").append("2").append("\n");
        sb.append("2").append(" ").append("3").append("\n");
        sb.append("4").append(" ").append("5").append("\n");
        sb.append("5").append(" ").append("6").append("\n");
        sb.append("6").append(" ").append("7").append("\n");
        sb.append("2").append(" ").append("4").append("\n");

        Scanner sc = new Scanner(sb.toString());

        UndirectedGraph undirectedGraph = new UndirectedGraph(sc);
        DepthFirstPath depthFirstPath = new DepthFirstPath(undirectedGraph, 0);

        boolean hasPathToThree = depthFirstPath.hasPathTo(3);
        boolean hasPathToSeven = depthFirstPath.hasPathTo(7);
        assertEquals(hasPathToThree, true);
        assertEquals(hasPathToSeven, true);
    }

    public void testBfs() throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("12").append("\n"); // Vertices
        sb.append("15").append("\n"); // Edges
        sb.append("0").append(" ").append("1").append("\n");
        sb.append("1").append(" ").append("2").append("\n");
        sb.append("2").append(" ").append("3").append("\n");
        sb.append("3").append(" ").append("0").append("\n");
        sb.append("2").append(" ").append("4").append("\n");
        sb.append("4").append(" ").append("5").append("\n");
        sb.append("5").append(" ").append("6").append("\n");
        sb.append("6").append(" ").append("7").append("\n");
        sb.append("7").append(" ").append("4").append("\n");
        sb.append("5").append(" ").append("8").append("\n");
        sb.append("8").append(" ").append("9").append("\n");
        sb.append("9").append(" ").append("10").append("\n");
        sb.append("10").append(" ").append("11").append("\n");
        sb.append("11").append(" ").append("8").append("\n");
        sb.append("2").append(" ").append("8").append("\n");

        Scanner sc = new Scanner(sb.toString());
        UndirectedGraph undirectedGraph = new UndirectedGraph(sc);
        BreadthFirstPath bfs = new BreadthFirstPath(undirectedGraph, 0);
        boolean hasPathTo10 =  bfs.hasPathTo(10);

        assertEquals(hasPathTo10, true);

        int count = 0;
        for (Integer w: bfs.pathTo(10)) {
            System.out.println(w);
            count++;
        }

        assertEquals(count, 6);
    }

    public void testConnectComponent() throws Exception {
        StringBuilder sb  = new StringBuilder();
        sb.append("8").append("\n"); // Vertices
        sb.append("6").append("\n"); // Edges
        sb.append("0").append(" ").append("1").append("\n");
        sb.append("1").append(" ").append("2").append("\n");
        sb.append("2").append(" ").append("3").append("\n");
        sb.append("4").append(" ").append("5").append("\n");
        sb.append("5").append(" ").append("6").append("\n");
        sb.append("6").append(" ").append("7").append("\n");


        Scanner sc = new Scanner(sb.toString());
        UndirectedGraph undirectedGraph = new UndirectedGraph(sc);
        ConnectedComponent cc = new ConnectedComponent(undirectedGraph);

        boolean connectedZeroWithThree = cc.connected(0, 3);
        boolean connectedFourWithSeven = cc.connected(4, 7);
        boolean connectedZeroWithSeven = cc.connected(0, 7);

        assertEquals(connectedZeroWithThree, true);
        assertEquals(connectedFourWithSeven, true);
        assertEquals(connectedZeroWithSeven, false);
    }
}