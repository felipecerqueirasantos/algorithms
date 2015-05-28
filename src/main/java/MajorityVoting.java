/**
 * Created by sky on 5/9/15.
 */
public class MajorityVoting {
    public static int majorityVoting(int[] arr) {
        int major = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                major = arr[i];
                count = 1;
            } else {
                if (arr[i] == major)
                    count++;
                else
                    count--;
            }

        }

        return major;
    }

    public static void main(String[] args) {
        System.out.println(majorityVoting(new int[]{1, 1, 1, 3, 3, 2, 2, 3, 3, 3, 2, 3, 3}));
        System.out.println(majorityVoting(new int[]{1, 1, 1, 2, 2, 2, 2}));
        System.out.println(majorityVoting(new int[]{1, 1, 2, 3, 1, 2, 3, 4}));
    }
}