package progs.p_49189;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/49189">
 * 프로그래머스 가장 먼 노드
 * </a>
 *
 * 2026 07 23
 */

public class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public int solution(int n, int[][] edge) {
        createGraph(edge);
        int[] result = bfs(n);

        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int value : result) {
            if (value > max) {
                count = 1;
                max = value;
            } else if (value == max) {
                count++;
            }
        }

        return count;
    }

    private void createGraph(int[][] edge) {
        int size = edge.length;

        for (int i = 0; i < size; i++) {
            int[] e = edge[i];
            int start = e[0];
            int end = e[1];

            List<Integer> startNext = graph.computeIfAbsent(start, s -> new ArrayList<>());
            startNext.add(end);

            List<Integer> endNext = graph.computeIfAbsent(end, s -> new ArrayList<>());
            endNext.add(start);
        }
    }

    private int[] bfs(int n) {
        int[] result = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        result[1] = 1;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> nextNodeList = graph.get(node);

            for (Integer nextNode : nextNodeList) {
                if (result[nextNode] == 0) {
                    result[nextNode] = result[node] + 1;

                    queue.add(nextNode);
                } else {
                    result[nextNode] = Math.min(result[nextNode], result[node] + 1);
                }
            }
        }

        return result;
    }
}
