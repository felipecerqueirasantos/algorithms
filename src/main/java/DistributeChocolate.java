/**
 * Created by sky on 5/11/15.
 */
/*
Its your Birthday. You want to distribute chocolates in orphanage. kids are standing in a row. each kid has batch with its age on it (Kids standing randomly in line).
Find the minimum number of chocolates required so that
1. every Kid should get minimum 1 chocolate
2. elder kid should get more chocolates than his adjacent kids

E.g. Kids are standing like
kids in line with ages : 2 6 1 2 9 1 1 4 9 6 3 5 1
number of chocolates:    1 2 1 2 3 1 1 2 3 2 1 2 1

2 6 1 2 9 1 1 4 9 6 3 5 1
1 2 1 2 3 1 1 2 3 1 1 2 1
 */


public class DistributeChocolate {

    public static void main(String[] args) {
        int[] kids = new int[] {2, 6, 1, 2, 9, 1, 1, 4, 9, 6, 3, 5, 1};
        int[] choco = new int[kids.length];

        // 2 6 1 2 9 1 1 4 9 6 3 5 1
        // 1 2 1 2 3 1 1 2 3 1 1 2 1

        int saved = 1;
        for (int i = 0; i < kids.length; i++) {
            if (i == 0) {
                choco[i] = saved;
                continue;
            }

            if (kids[i] <= kids[i - 1]) {
                saved = 1;
                choco[i] = saved;
            } else {
                choco[i] = ++saved;
            }
        }

        for (int i = 0; i < choco.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(choco[i]);
        }
        System.out.println();
    }
}