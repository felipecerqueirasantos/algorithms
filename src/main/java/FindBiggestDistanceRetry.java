/**
 * Created by sky on 5/9/15.
 */
public class FindBiggestDistanceRetry {
    public static int findBiggestDistance(int maxSteps, int broken) {
        return findBiggestDistance(0, 0, maxSteps, broken);
    }

    public static int findBiggestDistance(int position, int step, int maxSteps, int broken) {
        if (step == maxSteps) return position;

        if (position + (step + 1)== broken)
            return findBiggestDistance(position, step + 1, maxSteps, broken);

        return Math.max(findBiggestDistance(position + step + 1, step + 1, maxSteps, broken),
                findBiggestDistance(position, step + 1, maxSteps, broken));
    }

    public static void main(String[] args) {
        // 3 * 4 / 2 = 6
        System.out.println(findBiggestDistance(3, 7));

        // broken = 1
        // 0 2 3 4 = 9
        System.out.println(findBiggestDistance(4, 1));
    }
}
