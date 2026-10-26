package swe.s_1213;

import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        for (int tc = 1; tc <= 10; tc++) {
            int a = sc.nextInt();
            String target = sc.next();
            char[] input = sc.next().toCharArray();

            int value = 0;
            for (int i = 0; i < input.length; i++) {
                String slice = new String(Arrays.copyOfRange(input, i, i + target.length()));

                if (slice.equals(target)) value++;

            }
            System.out.println("#" + tc + " " + value);
        }
    }
}
