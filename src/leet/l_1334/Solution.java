package leet.l_1334;

import java.util.*;

public class Solution {
    int[][] graph;
    int[][] distance;
    int[] result;
    int MAX = 999999;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        createGraph(n, edges);

        for (int i = 0; i < n; i++) {
            createDistance(n, i, distanceThreshold);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = distance[i][j];

                if (value <= distanceThreshold && value != 0) result[i]++;

                // System.out.println("from: " + i + " to: " + j + " | value: " + value);
            }
        }

        int min = MAX;
        int number = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] <= min) {
                number = i;
                min = result[i];
            }
            // System.out.println("result from: " + i + " | value: " + result[i]);
        }

        return number;
    }

    private void createGraph(int n, int[][] edges) {
        graph = new int[n][n];
        distance = new int[n][n];
        result = new int[n];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph[from][to] = weight;
            graph[to][from] = weight;
        }
    }

    private void createDistance(int n, int start, int dt) {
        int[] targetDistance = distance[start];
        Arrays.fill(targetDistance, MAX);
        targetDistance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int from = current[0];
            int weight = current[1];

            if (targetDistance[from] < weight) continue;

            for (int to = 0; to < n; to++) {
                int toWeight = graph[from][to];
                if (toWeight == 0) continue;

                int sumWeight = weight + toWeight;
                if (targetDistance[to] < sumWeight) continue;

                targetDistance[to] = sumWeight;
                pq.offer(new int[]{to, sumWeight});
            }
        }
    }
}