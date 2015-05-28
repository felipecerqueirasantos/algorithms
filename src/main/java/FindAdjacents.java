import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sky on 5/26/15.
 */
/*
  1 2 3 4 5 6 7 8
  ---------------
1|0 0 0 0 0 0 0 1
2|0 0 0 0 1 0 0 1
3|0 0 0 1 0 0 0 0
4|0 1 1 1 1 0 0 0
5|0 0 0 0 1 0 0 0

Returns:
Array1 {(8,1) (8,2)}
Array2 {(5,2) (4,3) (2,4) (3,4) (4,4) (5,4) (5,5)}
 */

public class FindAdjacents {
    public static final class Point {
        private int line;
        private int column;

        public Point(int line, int column) {
            this.line = line;
            this.column = column;
        }

        @Override
        public String toString() {
            return "[" + line + ", " + column + "]";
        }
    }

    public static List<List<Point>> findAdjacents(int[][] matrix) {
        List<List<Point>> adjacents = new ArrayList<>();

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (matrix[l][c] == 1) {
                    List<Point> adjs = findAdjs(matrix, l, c);
                    adjacents.add(adjs);
                }
            }
        }

        return adjacents;
    }

    public static List<Point> findAdjs(int[][] matrix, int l, int c) {
        List<Point> adjs = new ArrayList<>();
        Queue<Point> queue = new ArrayDeque<>();

        queue.add(new Point(l, c));

        while (!queue.isEmpty()) {
            Point p = queue.remove();
            adjs.add(p);

            matrix[p.line][p.column] = 0;

            int line = p.line;
            int column = p.column;

            if (line + 1 < matrix.length && matrix[line + 1][column] == 1)
                queue.add(new Point(line + 1, column));

            if (line - 1 >= 0 && matrix[line - 1][column] == 1)
                queue.add(new Point(line - 1, column));

            if (column + 1 < matrix[line].length && matrix[line][column + 1] == 1)
                queue.add(new Point(line, column + 1));

            if (column - 1 >= 0 && matrix[line][column - 1] == 1)
                queue.add(new Point(line, column - 1));

        }

        return adjs;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0}
        };

        List<List<Point>> adjacents = findAdjacents(matrix);
        for (List<Point> adj: adjacents) {
            for (Point p: adj) {
                System.out.print(p + " ");
            }
            System.out.println();
        }

    }
}
