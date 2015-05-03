/**
 * Created by sky on 5/3/15.
 */
public class EuclidianDistance {
    public static double euclidianDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        System.out.println(euclidianDistance(1, 1, 6, 1));
        System.out.println(euclidianDistance(1, 1, 6, 6));
    }
}
