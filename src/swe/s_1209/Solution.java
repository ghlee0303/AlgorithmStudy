package swe.s_1209;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static final int N = 100;
    static int[][] grid = new int[N][N];

    static int[] dx = new int[]{1, 0, 1, -1};
    static int[] dy = new int[]{0, 1, 1, 1};

    public static void main(String args[]) throws Exception {
        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            createGrid();

            long max = 0;

            for (int i = 0; i < N; i++) {
                max = Math.max(max, sum(0, i, 0));
                max = Math.max(max, sum(i, 0, 1));
            }
            max = Math.max(max, sum(0, 0, 2));
            max = Math.max(max, sum(N - 1, 0, 3));

            System.out.println("#" + tc + " " + max);
        }
    }

    private static void createGrid() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }

    private static long sum(int x, int y, int direction) {
        int nx = x;
        int ny = y;

        long sum = grid[y][x];
        for (int i = 0; i < N; i++) {
            nx += dx[direction];
            ny += dy[direction];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) return sum;

            sum += grid[ny][nx];
        }

        return sum;
    }
}
