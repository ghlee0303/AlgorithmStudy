package swe.s_1244;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            char[] array = sc.next().toCharArray();
            int change = sc.nextInt();

            char[] dfsArray = dfs(array, change, 0);
            int value = toInteger(dfsArray);

            System.out.println("#" + tc + " " + value);
        }
    }

    private static char[] dfs(char[] array, int maxChange, int count) {
        int n = array.length;
        if (count >= n || count > maxChange) return array;

        int maxValue = 0;
        char[] maxArray = new char[n];

        for (int from = 0; from < n; from++) {
            for (int to = from; to < n; to++) {
                change(array, from, to);
                char[] dfsArray = dfs(array, maxChange, count + 1);
                int dfsValue = toInteger(dfsArray);

                if (dfsValue > maxValue) {
                    maxArray = dfsArray.clone();
                    maxValue = dfsValue;
                }

                change(array, to, from);
            }
        }

        return maxArray;
    }

    private static void change(char[] array, int from, int to) {
        char v = array[from];

        array[from] = array[to];
        array[to] = v;
    }

    private static int toInteger(char[] array) {
        return Integer.parseInt(new String(array));
    }
}
