package progs.p_72413;
import java.util.*;

public class Solution {
    int[][] graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new int[n][n];
        createGraph(fares);

        int[] aDist = createDist(a - 1, n);
        int[] bDist = createDist(b - 1, n);
        int[] sDist = createDist(s - 1, n);

        int answer = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (aDist[k] == Integer.MAX_VALUE
                    || bDist[k] == Integer.MAX_VALUE
                    || sDist[k] == Integer.MAX_VALUE) continue;

            int sum = aDist[k] + bDist[k] + sDist[k];
            answer = Math.min(answer, sum);
        }

        return answer;
    }

    private void createGraph(int[][] fares) {
        for (int[] fare : fares) {
            int start = fare[0] - 1;
            int end = fare[1] - 1;
            int value = fare[2];

            graph[start][end] = value;
            graph[end][start] = value;
        }
    }

    private int[] createDist(int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNumber = cur[0];
            int curValue = cur[1];

            if (dist[curNumber] < curValue) continue;

            for (int nextNumber = 0; nextNumber < n; nextNumber++) {
                int nextValue = graph[curNumber][nextNumber];
                if (nextValue == 0) continue;

                int sumValue = nextValue + curValue;
                if (dist[nextNumber] <= sumValue) continue;

                dist[nextNumber] = sumValue;
                pq.offer(new int[]{nextNumber, sumValue});
            }
        }
        return dist;
    }
}