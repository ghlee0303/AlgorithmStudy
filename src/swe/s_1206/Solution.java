package swe.s_1206;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            int[] buildingArray = new int[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                buildingArray[i] = sc.nextInt();
            }

            for (int i = 2; i < n - 2; i++) {
                int maxRoof = 0;

                for (int near = i - 2; near <= i + 2; near++) {
                    if (i == near) continue;

                    maxRoof = Math.max(maxRoof, buildingArray[near]);
                }

                int result = buildingArray[i] - maxRoof;

                if (result > 0) {
                    count += result;
                }
            }

            System.out.println("#" + (tc + 1) + " " + count);
        }
    }
}
