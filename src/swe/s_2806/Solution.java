package swe.s_2806;

import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Integer> queen;
    static int count, n;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            queen = new HashMap<>();
            count = 0;

            for (int i = 0; i < n; i++) {
                solve(i, 0);
            }

            System.out.println("#" + tc + " " + count);
        }
    }

    private static void solve(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) return;
        if (checkQueen(x, y)) return;

        queen.put(x, y);

        for (int i = 0; i < n; i++) {
            solve(i, y + 1);
        }

        if (queen.size() >= n) count++;

        queen.remove(x, y);
    }

    private static boolean checkQueen(int x, int y) {
        for (int qX : queen.keySet()) {
            int qY = queen.get(qX);

            if (x == qX) return true;
            if (y == qY) return true;
            if (isDiagonal(x, y, qX, qY)) return true;
        }

        return false;
    }

    private static boolean isDiagonal(int x, int y, int qX, int qY) {
        return Math.abs(x - qX) == Math.abs(y - qY);
    }
}
