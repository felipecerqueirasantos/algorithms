import java.util.Stack;

/**
 * Created by sky on 16/04/15.
 */
public class CardinalDirection {
    private static class Position {
        private int x;
        private int y;

        public Position() {
            x = 0;
            y = 0;
        }

        public String toString() {
            return "[x:" + x + ", y:" + y + "]";
        }
    }

    private static class Move {
        private char direction;
        private int amount;

        public Move(char direction, int amount) {
            this.direction = direction;
            this.amount = amount;
        }

        public Move reverse() { // Esqueci disto
            return new Move(direction, -amount);
        }

        public void apply(Position position) {
            switch(direction) {
                case 'N':
                    position.y += amount;
                    break;
                case 'S':
                    position.y -= amount;
                    break;
                case 'E':
                    position.x += amount;
                    break;
                case 'W':
                    position.x -= amount;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        String moviments = "NXN";

        Position position = new Position();
        Stack<Move> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moviments.length(); i++) {
            char chr = moviments.charAt(i);

            if (chr == 'N' || chr == 'S' || chr == 'E' || chr == 'W') {
                if (sb.length() > 1 && // Errei aqui
                        (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) >= '9')) {
                    sb.append(chr);
                } else {
                    sb.append('1').append(chr);
                }
            } else {
                sb.append(chr);
            }

            char lastChar = sb.charAt(sb.length() - 1);

            if (lastChar == 'N' || lastChar == 'S' ||
                    lastChar == 'E' || lastChar == 'W') {
                // End of command
                String cmd = sb.toString();
                int amount = Integer.parseInt(cmd.substring(0, cmd.length() - 1));

                // Apply movement
                Move move = new Move(lastChar, amount);
                move.apply(position);

                // Save command in the stack
                stack.push(move);

                // Resetting string builder
                sb = new StringBuilder();
            } else if (lastChar == 'X') {
                if (stack.isEmpty())
                    throw new IllegalStateException("Illegal movement. Moves stack is empty");

                Move lastMove = stack.pop();

                // Apply movement
                lastMove.reverse().apply(position);

                // Resetting
                sb = new StringBuilder();
            }
        }

        System.out.println(position);
    }
}
