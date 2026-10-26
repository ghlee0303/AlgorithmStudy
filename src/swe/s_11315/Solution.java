package swe.s_11315;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static boolean[][] grid;
    static int n;
    static int[] dx = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = new int[]{0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            createGrid();

            String result = "NO";

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (!grid[x][y]) continue;

                    for (int d = 0; d < 8; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (!grid[nx][ny]) continue;

                        if (search(x, y, d)) {
                            result = "YES";
                            break;
                        };
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static boolean search(int x, int y, int d) {
        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {
            nx += dx[d];
            ny += dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return false;
            if (!grid[nx][ny]) return false;
        }

        return true;
    }

    private static void createGrid() {
        n = sc.nextInt();
        grid = new boolean[n][n];

        final char STONE = 'o';

        for (int i = 0; i < n; i++) {
            char[] input = sc.next().toCharArray();

            for (int j = 0; j < n; j++) {
                char c = input[j];

                if (c == STONE) grid[j][i] = true;
            }
        }
    }
}
