package swe.s_1926;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int count = count369(i);

            if (count == 0) {
                System.out.print(i);
            } else {
                for (int j = 0; j < count; j++) {
                    System.out.print("-");
                }
            }
            System.out.print(" ");
        }
    }

    private static int count369(int value) {
        char[] charArray = String.valueOf(value).toCharArray();

        int count = 0;

        for (char c : charArray) {
            switch (c) {
                case '3':
                case '6':
                case '9': {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
