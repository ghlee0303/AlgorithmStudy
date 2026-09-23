package leet.l_743;
import java.util.*;

public class Solution {
    int[][] graph;
    int[] dist;

    public int networkDelayTime(int[][] times, int n, int k) {
        createGraph(times, n);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[]{k - 1, 0});
        dist[k - 1] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNumber = cur[0];
            int curValue = cur[1];

            if (curValue > dist[curNumber]) continue;

            for (int nextNumber = 0; nextNumber < n; nextNumber++) {
                int nextValue = graph[curNumber][nextNumber];
                if (nextValue < 0) continue;

                int sumValue = nextValue + curValue;
                if (dist[nextNumber] <= sumValue) continue;

                dist[nextNumber] = sumValue;
                pq.offer(new int[]{nextNumber, sumValue});
            }

        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dist[i]);
        }

        return result;
    }

    private void createGraph(int[][] times, int n) {
        dist = new int[n];
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            Arrays.fill(graph[i], -1);
        }

        for (int[] time : times) {
            int start = time[0] - 1;
            int end = time[1] - 1;
            int value = time[2];

            graph[start][end] = value;
        }
    }
}