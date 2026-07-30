package progs.p_86971.best;

import java.util.*;

/**
 *  클로드가 생성한 풀이
 */

public class Solution {
    List<Integer>[] adj;
    int[] dp;      // dp[v] = v 아래(자기 포함) 매달린 노드 수
    int n;

    public int solution(int n, int[][] wires) {
        this.n = n;
        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] w : wires) {          // 무방향이니 양쪽 다 넣기
            adj[w[0]].add(w[1]);
            adj[w[1]].add(w[0]);
        }

        dp = new int[n + 1];
        dfs(1, 0);                        // 1번을 맨 위에 매달고 아래부터 계산

        int answer = n;
        for (int v = 2; v <= n; v++)      // 루트(1번)는 제외
            answer = Math.min(answer, Math.abs(n - 2 * dp[v]));
        return answer;
    }

    private void dfs(int cur, int parent) {
        dp[cur] = 1;                      // 일단 나 자신 1명
        for (int next : adj[cur]) {
            if (next == parent) continue; // 부모로 되돌아가지 않기
            dfs(next, cur);               // 자식 먼저 계산하고
            dp[cur] += dp[next];          // 돌아와서 더하기
        }
    }
}
