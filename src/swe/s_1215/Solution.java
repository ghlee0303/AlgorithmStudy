package swe.s_1215;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static char[][] grid;
    static int MAX = 8;
    static int n;
    static int count;

    public static void main(String args[]) throws Exception {
        for (int tc = 1; tc <= 10; tc++) {
            n = sc.nextInt();
            createGrid();
            count = 0;

            for (int y = 0; y < MAX; y++) {
                for (int x = 0; x < MAX; x++) {
                    if (toX(x, y)) count++;
                    if (toY(x, y)) count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }

    private static void createGrid() {
        grid = new char[MAX][MAX];

        for (int y = 0; y < MAX; y++) {
            char[] input = sc.next().toCharArray();
            for (int x = 0; x < MAX; x++) {
                grid[y][x] = input[x];
            }
        }
    }

    private static boolean toX(int x, int y) {
        int otherX = n + x - 1;

        if (otherX >= MAX) return false;

        for (int i = 0; i < n / 2; i++) {
            char first = grid[y][x++];
            char second = grid[y][otherX--];

            if (first != second) return false;
        }

        return true;
    }

    private static boolean toY(int x, int y) {
        int otherY = n + y - 1;

        if (otherY >= MAX) return false;

        for (int i = 0; i < n / 2; i++) {
            char first = grid[y++][x];
            char second = grid[otherY--][x];

            if (first != second) return false;
        }

        return true;
    }
}
