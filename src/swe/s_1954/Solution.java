package swe.s_1954;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[][] array = new int[n][n];

            int x = 0, y = 0;
            int count = 0;
            for (int i = 1; i <= n * n; i++) {
                if (count == 0) {
                    array[y][x] = i;
                    x++;

                    if (x + 1 >= n || array[y][x + 1] != 0) {
                        count++;
                    }
                } else if (count == 1) {
                    array[y][x] = i;
                    y++;

                    if (y + 1 >= n || array[y + 1][x] != 0) {
                        count++;
                    }
                } else if (count == 2) {
                    array[y][x] = i;
                    x--;

                    if (x - 1 < 0 || array[y][x - 1] != 0) {
                        count++;
                    }
                } else if (count == 3) {
                    array[y][x] = i;
                    y--;

                    if (y - 1 < 0 || array[y - 1][x] != 0) {
                        count = 0;
                    }
                }
            }

            System.out.println("#" + tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
