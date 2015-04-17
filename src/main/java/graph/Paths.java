package graph;

/**
 * Created by sky on 08/04/15.
 */
public interface Paths {
    boolean hasPathTo(int v);
    Iterable<Integer> pathTo(int v);
}

