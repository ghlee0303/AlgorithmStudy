package swe.s_5215.other;

import java.util.*;

public class Solution {
    static int[] scoreArray;
    static int[] valueArray;
    static int maxSize, maxValue;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            maxSize = sc.nextInt();
            maxValue = sc.nextInt();
            scoreArray = new int[maxSize];
            valueArray = new int[maxSize];

            for (int i = 0; i < maxSize; i++) {
                int score = sc.nextInt();
                int value = sc.nextInt();

                scoreArray[i] = score;
                valueArray[i] = value;
            }

            int value = dfs(0, 0, 0);

            System.out.println("#" + tc + " " + value);
        }
    }

    private static int dfs(int index, int sumValue, int sumScore) {
        if (sumValue > maxValue) return 0;
        if (index < 0 || index >= maxSize) return sumScore;

        int pick = Math.max(sumValue, dfs(index + 1, sumValue + valueArray[index], sumScore + scoreArray[index]));
        int skip = Math.max(sumValue, dfs(index + 1, sumValue, sumScore));

        return pick < skip ? sumScore : sumScore + scoreArray[index];
    }
}
