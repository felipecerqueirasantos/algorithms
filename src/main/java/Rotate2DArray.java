import javafx.geometry.Pos;

/**
 * Created by sky on 04/05/15.
 */
public class Rotate2DArray {
    public static void rotateMatrix(int[][] matrix) {
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int saved = matrix[layer][layer];

            int line;
            int column;

            // Right
            for (line = layer, column = layer + 1; column < matrix[line].length - layer; column++) {
                int tmp = matrix[line][column];
                matrix[line][column] = saved;
                saved = tmp;
            }

            // Down
            for (line = line + 1, column = column - 1; line < matrix.length - layer; line++) {
                int tmp = matrix[line][column];
                matrix[line][column] = saved;
                saved = tmp;
            }

            // Left
            for (line = line - 1, column = column - 1; column >= layer; column--) {
                int tmp = matrix[line][column];
                matrix[line][column] = saved;
                saved = tmp;
            }

            // Up
            for (line = line - 1, column = column + 1; line >= layer; line--) {
                int tmp = matrix[line][column];
                matrix[line][column] = saved;
                saved = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        int[][] matrix2 = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};


        printMatrix(matrix2);
        rotateMatrix(matrix2);
        printMatrix(matrix2);

        System.out.println("---------");

        for (int layer = 0; layer < matrix.length / 2; layer++) {

            int column;
            int line;

            int prev = matrix[layer][layer];

            // Right
            for (column = layer + 1, line = layer; column < matrix[line].length - layer; column++) {
                int saved = matrix[line][column];
                matrix[line][column] = prev;
                prev = saved;
            }

            // Down
            for (column = column - 1, line = line + 1; line <= matrix.length - 1 - layer; line++) {
                int saved = matrix[line][column];
                matrix[line][column] = prev;
                prev = saved;
            }

            // Left
            for (line = line - 1, column = column - 1; column >= 0 + layer; column--) {
                int saved = matrix[line][column];
                matrix[line][column] = prev;
                prev = saved;
            }

            // Up (finally) :)
            for (column = column + 1, line = line - 1; line >= 0 + layer; line--) {
                int saved = matrix[line][column];
                matrix[line][column] = prev;
                prev = saved;
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (c > 0) System.out.print(" ");
                System.out.format("%02d", matrix[l][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
