package swe.s_1204;

import java.util.Scanner;

public class Solution {

    static int MAX = 1000;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int[] array = new int[MAX];
            int tcNumber = sc.nextInt();

            int maxValue = 0;
            int maxCount = 0;

            for (int i = 0; i < MAX; i++) {
                int value = sc.nextInt();

                array[value]++;

                if (maxCount < array[value]) {
                    maxCount = array[value];
                    maxValue = value;
                } else if (maxCount == array[value] && maxValue < value) {
                    maxCount = array[value];
                    maxValue = value;
                }
            }

            System.out.println("#" + tc + " " + maxValue);
        }
    }
}
