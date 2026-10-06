package swe.s_1225;

import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static int N = 8;
    static int CYCLE = 5;

    public static void main(String args[]) throws Exception {

        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }

            int[] newArray = createNewArray(array);

            System.out.print("#" + tc);
            for (int i = 0; i < N; i++) {
                System.out.print(" " + newArray[i]);
            }
            System.out.println();
        }
    }

    private static int[] createNewArray(int[] array) {
        int[] newArray = new int[N];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.add(array[i]);
        }

        int cycleIndex = 1;
        while (true) {
            int value = queue.poll();
            int newValue = value - cycleIndex++;
            if (cycleIndex > CYCLE) cycleIndex = 1;

            if (newValue > 0) {
                queue.add(newValue);
            } else {
                queue.add(0);
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            newArray[i] = queue.poll();
        }

        return newArray;
    }
}
