package progs.p_86971;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        solution.solution(n, wires);

    }
}
