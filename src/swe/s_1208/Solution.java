package swe.s_1208;

import java.util.*;

public class Solution {
    static final int MAX = 100;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int[] grid = new int[MAX];
            int dump = sc.nextInt();

            for (int i = 0; i < MAX; i++) {
                grid[i] = sc.nextInt();
            }

            for (int i = 0; i < dump; i++) {
                int maxIndex = 0;
                int maxValue = 0;
                int minIndex = 0;
                int minValue = Integer.MAX_VALUE;

                for (int j = 0; j < MAX; j++) {
                    if (grid[j] > maxValue) {
                        maxValue = grid[j];
                        maxIndex = j;
                    }

                    if (grid[j] < minValue) {
                        minValue = grid[j];
                        minIndex = j;
                    }
                }

                grid[minIndex]++;
                grid[maxIndex]--;
            }

            int maxValue = 0;
            int minValue = Integer.MAX_VALUE;

            for (int i = 0; i < MAX; i++) {
                if (grid[i] > maxValue) {
                    maxValue = grid[i];
                }

                if (grid[i] < minValue) {
                    minValue = grid[i];
                }
            }
            System.out.println("#" + tc + " " + (maxValue - minValue));
        }
    }
}
