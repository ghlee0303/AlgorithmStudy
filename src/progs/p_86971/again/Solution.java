package progs.p_86971.again;

import java.util.*;

/**
 *  다시 푼거
 */

public class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] dp;

    public int solution(int n, int[][] wires) {
        dp = new int[n + 1];
        createGraph(n, wires);
        dfs(1, 0);

        int result = n;
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];

            int a = Math.min(dp[start], dp[end]);

            result = Math.min(result, Math.abs(n - 2 * a));
        }

        return result;
    }

    private void createGraph(int n, int[][] wires) {
        for (int i = 1; i <= n + 1; i++) graph.add(new ArrayList<>());
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];

            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }

    private void dfs(int start, int parent) {
        dp[start] = 1;

        for (int next : graph.get(start)) {
            if (parent == next) continue;
            dfs(next, start);
            dp[start] += dp[next];
        }
    }
}
