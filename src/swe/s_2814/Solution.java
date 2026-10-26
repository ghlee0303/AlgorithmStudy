package swe.s_2814;

import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static boolean[][] graph;
    static int n, m;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();

            createGraph();

            int value = 1;
            for (int i = 0; i < n; i++) {
                value = Math.max(value,  dfs(i, 1));
            }
            System.out.println("#" + tc + " " + value);
        }
    }

    private static void createGraph() {
        graph = new boolean[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;

            graph[to][from] = true;
            graph[from][to] = true;
        }
    }

    private static int dfs(int from, int count) {
        int max = count;

        boolean[] next = graph[from];
        visited[from] = true;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            boolean node = next[i];
            if (!node) continue;

            max = Math.max(max, dfs(i, count + 1));
        }
        visited[from] = false;

        return max;
    }
}
