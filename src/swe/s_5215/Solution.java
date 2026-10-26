package swe.s_5215;

import java.util.*;

public class Solution {
    static int maxSize, maxCal;
    static int[] scoreArray, calArray;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            maxSize = sc.nextInt();
            maxCal = sc.nextInt();

            scoreArray = new int[maxSize];
            calArray = new int[maxSize];

            for (int i = 0; i < maxSize; i++) {
                int score = sc.nextInt();
                int cal = sc.nextInt();

                scoreArray[i] = score;
                calArray[i] = cal;
            }

            int max = 0;
            for (int i = 0; i < maxSize; i++) {
                max = Math.max(dfs(i, 0, 0), max);
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    private static int dfs(int index, int scoreSum, int calSum) {
        if (index >= maxSize) return scoreSum;

        int score = scoreArray[index];
        int cal = calArray[index];

        if (calSum + cal > maxCal) return scoreSum;

        scoreSum += score;
        calSum += cal;

        int scoreMax = scoreSum;
        for (int i = index + 1; i < maxSize; i++) {
            scoreMax = Math.max(scoreMax, dfs(i, scoreSum, calSum));
        }

        return scoreMax;
    }
}
