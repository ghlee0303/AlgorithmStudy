package swe.s_6190;

import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] array;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            int value = danjo();
            System.out.println("#" + tc + " " + value);
        }
    }

    private static int danjo() {
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int value = array[i] * array[j];

                if (!isDanjo(value)) continue;

                max = Math.max(max, value);
            }
        }

        return max;
    }

    private static boolean isDanjo(int value) {
        int[] digit = toDigit(value);

        if (digit.length < 2) return true;

        int prev = -1;
        for (int d : digit) {
            if (prev > d) return false;
            prev = d;
        }

        return true;
    }

    private static int[] toDigit(int value) {
        String s = String.valueOf(value);
        int[] digit = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            digit[i] = s.charAt(i) - '0';
        }

        return digit;
    }
}
