package swe.s_27005;

import java.util.*;

public class Solution {
    static int MAX = 1000;
    static int[] A = new int[MAX + 1];

    public static void main(String args[]) throws Exception {
        createSeq();

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int input = sc.nextInt();
            System.out.println(A[input]);
        }
    }

    private static void createSeq() {
        A[0] = 1;
        A[1] = 1;

        for (int i = 2; i <= MAX; i++) {
            int kMax = i / 2;

            boolean[] banned = new boolean[MAX];

            for (int k = 1; k <= kMax; k++) {
                int value = 2 * A[i - k] - A[i - 2 * k];

                if (value <= 0) continue;

                banned[value] = true;
            }

            int x = 1;
            while (banned[x])
                x++;

            A[i] = x;
        }
    }
}