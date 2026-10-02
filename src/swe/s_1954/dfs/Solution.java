package swe.s_1954.dfs;

import java.util.Scanner;

public class Solution {
    static int[] DX = new int[]{1, 0, -1, 0};
    static int[] DY = new int[]{0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[][] array = new int[n][n];

            dfs(array, 0, 0, 1, 0);

            System.out.println("#" + tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(array[j][i] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void dfs(int[][] array, int x, int y, int value, int direction) {
        int n = array.length;
        if (n * n < value) return;

        array[x][y] = value;

        int nx = x + DX[direction];
        int ny = y + DY[direction];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n || array[nx][ny] != 0){
            direction = (direction + 1) % 4;
            nx = x + DX[direction];
            ny = y + DY[direction];
        }

        dfs(array, nx, ny, ++value, direction);
    }
}
