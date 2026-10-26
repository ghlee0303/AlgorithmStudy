package swe.s_1860;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            String result = solve(n, m, k) ? "Possible" : "Impossible";

            System.out.println("#" + tc + " " + result);
        }
    }

    private static boolean solve(int n, int m, int k) {
        int stock = 0;
        int remain = 0;

        int[] customer = new int[n];
        for (int i = 0; i < n; i++) {
            customer[i] = sc.nextInt();
        }

        for (int c : customer) {
            int s = m + remain;
            remain += c - m;

            if (c < s) {
                if (stock <= 0) return false;
                stock--;
            } else {
                int multiple = c / s;
                stock += k * multiple - 1;
            }
        }

        return true;
    }
}
