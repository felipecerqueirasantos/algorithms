/**
 * Created by sky on 5/5/15.
 */
/*
 * Invert90Degrees
 * Felipe Cerqueira
 */

public class Invert90Degrees {

    /*
     01 02 03 04
     05 06 07 08
     09 10 11 12
     13 14 15 16

     01 05 09 13
     02 06 10 14
     03 07 11 15
     04 08 12 16

     13 09 05 01
     14 10 06 02
     15 11 07 03
     06 12 08 04
    */

    public static void rotateInplace(int[][]matrix) {
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            for (int column = layer; column < matrix[layer].length - layer; column++) {
                exch(matrix, layer, column, column, layer);
            }
        }


        for (int line = 0; line < matrix.length; line++) {
            int cBegin = 0;
            int cEnd = matrix[line].length - 1;

            while (cBegin < cEnd) {
                exch(matrix, line, cBegin, line, cEnd);
                cBegin++;
                cEnd--;
            }
        }
    }

    public static void exch(int[][]matrix, int lineTo, int columnTo, int lineFrom, int columnFrom) {
        int tmp = matrix[lineTo][columnTo];
        matrix[lineTo][columnTo] = matrix[lineFrom][columnFrom];
        matrix[lineFrom][columnFrom] = tmp;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j > 0) System.out.print(" ");
                System.out.format("%02d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{ {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
        rotateInplace(matrix);
        printMatrix(matrix);
    }
}