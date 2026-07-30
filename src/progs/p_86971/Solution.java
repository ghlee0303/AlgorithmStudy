package progs.p_86971;

import java.util.*;

/**
 * 프로그래머스 전력망을 둘로 나누기 DP
 * 해설보고함
 */

public class Solution {
    Node[] nodes;

    static class Node {
        int number;
        Map<Integer, Integer> nextMap;

        public Node(int number) {
            this.number = number;
            nextMap = new HashMap<>();
        }

        public int sumNext() {
            int value = 0;

            for (Integer nextIndex : nextMap.values()) {
                value += nextIndex;
            }

            return value;
        }

        public void addNext(Node next) {
            nextMap.put(next.number , 0);
        }

        public void addNextSize(int index, int add) {
            int nextSize = nextMap.getOrDefault(index, 0);

            nextMap.put(index, nextSize + add);
        }
    }

    public int solution(int n, int[][] wires) {
        nodes = new Node[n];
        createNodeList(wires);

        test(0, -1);

        int min = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int start = wire[0] - 1;
            int end = wire[1] - 1;

            int startGroup = nodes[start].nextMap.get(end);
            int endGroup = nodes[end].nextMap.get(start);

            int group = Math.max(startGroup, endGroup);
            int other = Math.abs(group - n);
            int result = Math.abs(group - other);

            min = Math.min(min, result);
        }

        return min;
    }

    private void createNodeList(int[][] wires) {

        for (int[] wire : wires) {
            int start = wire[0] - 1;
            int end = wire[1] - 1;

            Node startNode = nodeGet(start);
            Node endNode = nodeGet(end);

            startNode.addNext(endNode);
            endNode.addNext(startNode);
        }
    }

    private int test(int index, int parent) {
        Node node = nodes[index];

        for (Integer nextIndex : node.nextMap.keySet()) {
            if (nextIndex == parent) continue;

            node.addNextSize(nextIndex, test(nextIndex, index));
        }

        return node.sumNext() + 1;
    }

    private Node nodeGet(int index) {
        if (nodes[index] == null) {
            nodes[index] = new Node(index);
        }

        return nodes[index];
    }
}
