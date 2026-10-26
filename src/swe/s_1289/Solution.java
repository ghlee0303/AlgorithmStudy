package swe.s_1289;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static boolean[] memory, original;
    static int n;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            createMemory();

            int value = solve();
            System.out.println("#" + tc + " " + value);
        }
    }

    private static void createMemory() {
        char[] input = sc.next().toCharArray();

        n = input.length;
        memory = new boolean[n];
        original = new boolean[n];

        for (int i = 0; i < n; i++) {
            original[i] = input[i] == '1';
        }
    }

    private static int solve() {
        int count = 0;

        if (memory[0] != original[0]) count++;
        boolean prev = original[0];

        for (int i = 1; i < n; i++) {
            if (original[i] != prev) count++;
            prev = original[i];
        }

        return count;
    }
}
