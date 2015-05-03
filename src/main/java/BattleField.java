import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sky on 5/3/15.
 */
public class BattleField {
    // Character to identify a soldier in the map
    public static final char SOLDIER = 'S';
    public static final char TARGET_ON_SIGHT = 'K';

    // Character to identify the target
    public static final char TARGET = 'T';

    // Character to identify bullet proof positions
    public static final char BULLET_PROOF = '#';

    // Character to identify places with vision to the target
    public static final char SHOOTING_POINT = 'O';



    public static String[] nearestShootingPoint(int[] boardSize, int[] soldierPosition, int[] targetPosition,
                                                String[] bulletProof) {

        char[][] board = new char[boardSize[0]][boardSize[1]];
        setPosition(board, SOLDIER, soldierPosition);
        setPosition(board, TARGET, targetPosition);

        // BulletProff position format: x#y
        for (String s: bulletProof) {
            String[] arr = s.split("#");

            // Sanity checking the bullet proof format
            if (arr.length != 2) {
                throw new IllegalArgumentException("Invalid bullet proof position: " + s);
            }

            int[] p = new int[2];
            p[0] = Integer.parseInt(arr[0]);
            p[1] = Integer.parseInt(arr[1]);

            setPosition(board, BULLET_PROOF, p);
        }

        TargetMovement targetMovement = new TargetMovement(board, targetPosition[0] - 1, targetPosition[1] - 1);
        targetMovement.walkFrom();

        SoldierMovement soldierMovement = new SoldierMovement(board, soldierPosition[0] - 1, soldierPosition[1] - 1);
        soldierMovement.walkFrom();

        String[] sightPositions = soldierMovement.getSightPositions();

        for (String s: sightPositions) {
            System.out.println(s);
        }

        printBoard(board);
        return null;
    }

    public static void setPosition(char[][] board, char identifier, int[] position) {
        board[position[0] - 1][position[1] - 1] = identifier;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j > 0) System.out.print(" ");
                if (board[i][j] == 0) System.out.print('.');
                else System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nearestShootingPoint(new int[]{6, 6}, new int[]{1, 1}, new int[]{1, 6}, new String[]{"2#2", "4#5"});
    }

    public abstract static class Movement {
        protected char[][] board;
        protected int l;
        protected int c;

        public Movement(char[][] board, int l, int c) {
            this.board = board;
            this.l = l;
            this.c = c;
        }

        public abstract boolean updatePosition(int l, int c);

        public void walkFrom() {
            int dc;
            int dl;

            dl = l;
            dc = c;

            // North
            while (updatePosition(dl, dc)) {
                dl++;
            }

            // South
            dl = l;
            dc = c;
            while (updatePosition(dl, dc)) {
                dl--;
            }

            // East
            dc = c;
            dl = l;
            while (updatePosition(dl, dc)) {
                dc++;
            }

            // West
            dc = c;
            dl = l;
            while (updatePosition(dl, dc)) {
                dc--;
            }

            dc = c;
            dl = l;
            while (updatePosition(dl, dc)) {
                dc++;
                dl--;
            }

            dc = c;
            dl = l;
            while (updatePosition(dl, dc)) {
                dc--;
                dl++;
            }

            dc = c;
            dl = l;
            while (updatePosition(dl, dc)) {
                dc++;
                dl++;
            }

            dc = c;
            dl = l;
            while (updatePosition(dl, dc)) {
                dc--;
                dl--;
            }
        }
    }

    public final static class TargetMovement extends Movement {

        public TargetMovement(char[][] board, int l, int c) {
            super(board, l, c);
        }

        @Override
        public boolean updatePosition(int l, int c) {
            if (l < 0 || c < 0)
                return false;

            if (l >= board.length)
                return false;

            if (c >= board[l].length)
                return false;

            if (board[l][c] == SOLDIER) {
                // Don't need to go further
                board[l][c] = TARGET_ON_SIGHT;
                return false;
            }

            if (board[l][c] == TARGET)
                return true;

            if (board[l][c] == BULLET_PROOF)
                return false;

            board[l][c] = SHOOTING_POINT;
            return true;
        }
    }

    public final static class SoldierMovement extends Movement {
        private boolean dontNeedToMove = false;
        private List<String> sightList;
        private double closer;

        public SoldierMovement(char[][] board, int l, int c) {
            super(board, l, c);
            sightList = new ArrayList<>();
            closer = Double.MAX_VALUE;
        }

        @Override
        public boolean updatePosition(int l, int c) {
            if (dontNeedToMove)
                return false;

            if (l < 0 || c < 0)
                return false;

            if (l >= board.length)
                return false;

            if (c >= board[l].length)
                return false;

            if (board[l][c] == BULLET_PROOF) {
                return false;
            }

            if (board[l][c] == TARGET_ON_SIGHT) {
                insert(l + 1, c + 1);

                board[l][c] = 'K';
                dontNeedToMove = true;
                return false;
            }

            if (board[l][c] == SHOOTING_POINT) {
                insert(l + 1, c + 1);
                board[l][c] = 'K';
                return false;
            }

            return true;
        }

        public static double euclidianDistance(double x1, double y1, double x2, double y2) {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

        private void insert(int l, int c) {
            double dist = euclidianDistance(super.l, super.c, l, c);
            if (dist > closer)
                return;

            if (dist == closer) {
                sightList.add(l + "#" + c);
                return;
            }

            // New position closer found
            sightList.clear();
            sightList.add(l + "#" + c);
            closer = dist;
        }

        public String[] getSightPositions() {
            String[] l = new String[sightList.size()];
            sightList.toArray(l);
            return l;
        }
    }
}