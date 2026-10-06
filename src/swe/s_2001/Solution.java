package swe.s_2001;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int n, m, minX, minY, maxX, maxY;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            createGrid();

            int maxCount = 0;
            int box = n - m;
            for (int i = 0; i <= box; i++) {
                for (int j = 0; j <= box; j++) {
                    visited = new boolean[n][n];
                    minX = i;
                    minY = j;
                    maxX = m + i;
                    maxY = m + j;

                    int count = dfs(i, j, 0, 0);
                    maxCount = Math.max(count, maxCount);
                }
            }

            System.out.println("#" + tc + " " + maxCount);
        }
    }

    private static void createGrid() {
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }

    private static int dfs(int x, int y, int index, int count) {
        if (x < minX || y < minY || x >= maxX || y >= maxY) return 0;
        if (visited[y][x]) return 0;
        if (index >= m * m) return count;

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int direction = i % 4;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            count += dfs(nx, ny, index + 1, count);
        }

        return count + grid[y][x];
    }
}
