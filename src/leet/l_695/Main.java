package leet.l_695;

public class Main {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        Solution s = new Solution();

        System.out.println(s.maxAreaOfIsland(grid));
    }

    private static void test2() {
        int[][] grid = {
                {1,0,1,0,0},
                {1,1,1,0,0},
                {0,0,1,0,0},
        };

        Solution s = new Solution();

        System.out.println(s.maxAreaOfIsland(grid));
    }
}
