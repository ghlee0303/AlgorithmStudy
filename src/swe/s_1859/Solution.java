package swe.s_1859;

import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            long[] valueArray = new long[n];

            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                valueArray[i] = value;
            }

            int i = 0;
            int maxIndex = findMaxIndex(i, n, valueArray);
            long profit = 0;

            while (i < n) {
                int count = maxIndex - i;
                long sum = 0;

                for (; i < maxIndex; i++) {
                    sum += valueArray[i];
                }
                profit += valueArray[maxIndex] * count - sum;

                i++;
                maxIndex = findMaxIndex(i, n, valueArray);
            }

            System.out.println("#" + (tc + 1) + " " + profit);
        }
    }

    private static int findMaxIndex(int start, int n, long[] valueArray) {
        long max = 0;
        int maxIndex = 0;

        for (int i = start; i < n; i++) {
            if (max >= valueArray[i]) continue;
            max = valueArray[i];
            maxIndex = i;
        }

        return maxIndex;
    }
}
