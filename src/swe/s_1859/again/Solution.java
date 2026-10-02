package swe.s_1859.again;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            long[] array = new long[n];

            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            long profit = 0;

            for (int start = 0; start < array.length; start++) {
                int maxIndex = findMaxIndex(array, start);
                int count = maxIndex - start;
                long sumValue = sumArray(array, start, maxIndex);

                profit += array[maxIndex] * count - sumValue;
                start = maxIndex;
            }

            System.out.println("#" + tc + " " + profit);
        }
    }

    private static int findMaxIndex(long[] array, int start) {
        long max = 0;
        int index = 0;

        for (int i = start; i < array.length; i++) {
            if (array[i] <= max) continue;
            max = array[i];
            index = i;
        }

        return index;
    }

    private static long sumArray(long[] array, int start, int end) {
        long sum = 0;

        for (int i = start; i < end; i++) {
            sum += array[i];
        }

        return sum;
    }
}
