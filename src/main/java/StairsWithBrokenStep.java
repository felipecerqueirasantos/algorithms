/**
 * Created by sky on 5/1/15.
 */
public class StairsWithBrokenStep {
    public static int longerDistance(int maxSteps, int broken) {
        return longerDistance(0, 0, maxSteps, broken);
    }

    public static int longerDistance(int position, int step, int maxSteps, int broken) {
        if (step > maxSteps || position == broken) return position;
        return Math.max(longerDistance(position + step, step + 1, maxSteps, broken),
                longerDistance(position, step + 1, maxSteps, broken));
    }

    public static void main(String[] args) {
        System.out.println(longerDistance(4, 6));
    }
}
