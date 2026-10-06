package swe.s_2805;

import java.util.Scanner;

public class Solution {
    static int[][] grid;
    static Scanner sc = new Scanner(System.in);
    static int n;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            createGrid();

            int sum = dfs(0, 0);

            System.out.println("#" + tc + " " + sum);
        }
    }

    private static void createGrid() {
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = sc.next().toCharArray();

            for (int j = 0; j < n; j++) {
                grid[i][j] = input[j] - '0';
            }
        }
    }

    private static int dfs(int y, int profit) {
        if (y >= n) return profit;

        int middle = n / 2;

        int xRange = 2 * y + 1;
        if (y > middle) {
            xRange = (y - 2 * (y - middle)) * 2 + 1;
        }
        int xStart = Math.abs(y - middle);

        for (int x = xStart; x < xRange + xStart; x++) {
            profit += grid[y][x];
        }

        return dfs(y + 1, profit);
    }
}
