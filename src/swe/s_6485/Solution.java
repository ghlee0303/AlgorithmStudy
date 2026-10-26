package swe.s_6485;

import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static int n, p;
    static int[] busStation;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            createBusStation();

            System.out.print("#" + tc + " ");
            solve();
        }
    }

    private static void createBusStation() {
        n = sc.nextInt();
        busStation = new int[5001];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start; j <= end; j++) {
                busStation[j]++;
            }
        }
    }

    private static void solve() {
        p = sc.nextInt();

        for (int i = 0; i < p; i++) {
            int target = sc.nextInt();

            System.out.print(busStation[target] + " ");
        }

        System.out.println();
    }
}
