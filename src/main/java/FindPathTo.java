/**
 * Created by sky on 5/28/15.
 */
public class FindPathTo {
    public static boolean hasPathTo(int[][] matrix, int line, int column,
                                    int toLine, int toColumn) {
        if (line < 0 || column < 0)
            return false;

        if (line > matrix.length - 1 || column > matrix[line].length - 1)
            return false;

        if (matrix[line][column] == 1)
            return false;

        if (matrix[line][column] != 0)
            return false;

        matrix[line][column]++;

        if (line == toLine && column == toColumn) {
            // Target reached
            return true;
        }

        boolean foundGoingRight = hasPathTo(matrix, line, column + 1, toLine, toColumn);
        if (foundGoingRight) return true;

        boolean foundGoingLeft = hasPathTo(matrix, line, column - 1, toLine, toColumn);
        if (foundGoingLeft) return true;

        boolean foundGoingUp = hasPathTo(matrix, line + 1, column, toLine, toColumn);
        if (foundGoingUp) return true;

        boolean foundGoingDown = hasPathTo(matrix, line - 1, column, toLine, toColumn);
        if (foundGoingDown) return true;

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0}
        };

        System.out.println(hasPathTo(matrix, 0, 0, 0, 3)); // true
        System.out.println(hasPathTo(matrix, 3, 3, 0, 0)); // false
        System.out.println(hasPathTo(matrix, 0, 0, 3, 3)); // false
    }
}