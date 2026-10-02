package leet.l_733;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        test1();
        System.out.println();
        test2();
    }

    private static void test1() {
        Solution s = new Solution();

        int[][] image = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };

        int sr = 1, sc = 1, color = 2;

        int[][] result = s.floodFill(image, sr, sc, color);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void test2() {
        Solution s = new Solution();

        int[][] image = new int[][]{
                {0, 0, 0}, {1, 0, 0}
        };

        int sr = 1, sc = 0, color = 2;

        int[][] result = s.floodFill(image, sr, sc, color);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}