package progs.p_49189;

public class Test {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        Solution solution = new Solution();
        int value = solution.solution(n, edge);
        System.out.println(value);
    }

}
