/**
 * Created by sky on 27/05/15.
 */
public class RotateSquareMatrix {
    public static void rotateMatrix(int[][] matrix) {
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int line = layer;
            int column = layer;

            int saved = matrix[line][column];

            // Going right
            column++;
            while (column < matrix[line].length - layer) {
                int t = matrix[line][column];
                matrix[line][column] = saved;
                saved = t;
                column++;
            }

            // Going down
            column--;
            line++;
            while (line < matrix.length - layer) {
                int t = matrix[line][column];
                matrix[line][column] = saved;
                saved = t;
                line++;
            }

            // Going left
            line--;
            column--;
            while (column >= layer) {
                int t = matrix[line][column];
                matrix[line][column] = saved;
                saved = t;
                column--;
            }

            // Going up
            column++;
            line--;
            while (line >= layer) {
                int t = matrix[line][column];
                matrix[line][column] = saved;
                saved = t;
                line--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,   2,  3,  4},
                {12, 13, 14,  5},
                {11, 16, 15,  6},
                {10,  9,  8,  7}
        };

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (c > 0) System.out.print(" ");
                System.out.format("%02d", matrix[l][c]);
            }
            System.out.println();
        }

        System.out.println();

        rotateMatrix(matrix);

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (c > 0) System.out.print(" ");
                System.out.format("%02d", matrix[l][c]);
            }
            System.out.println();
        }
    }
}
