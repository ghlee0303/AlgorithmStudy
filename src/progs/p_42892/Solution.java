package progs.p_42892;

import java.util.*;

/**
 * 프로그래머스 길 찾기 게임
 */

public class Solution {
    int[][] answer;
    int preOrderIndex = 0;
    int inOrderIndex = 0;
    int root = 0;
    List<List<Node>> graph;

    static class Node {
        int number;
        int x;
        int y;

        public Node(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] solution(int[][] nodeInfo) {
        answer = new int[2][nodeInfo.length];

        createGraph(nodeInfo);
        preOrder(graph.get(root).get(0));

        return answer;
    }

    private void createGraph(int[][] nodeInfo) {
        graph = new ArrayList<>();
        for (int i = 0; i < nodeInfo.length; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < nodeInfo.length; i++) {
            int[] node = nodeInfo[i];
            int x = node[0];
            int y = node[1];

            List<Node> yList = graph.get(y);

            yList.add(new Node(i, x, y));
            root = Math.max(root, y);
        }
    }

    public void preOrder(Node parent) {
        if (parent == null) return;

        Node[] childs = getChild(parent);

        if (childs[0] != null) {
            preOrder(childs[0]);
            answer[0][preOrderIndex++] = childs[0].number;
        }

        if (childs[1] != null) {
            preOrder(childs[1]);
            answer[0][preOrderIndex++] = childs[1].number;
        }

        answer[0][preOrderIndex++] = parent.number;
    }

    private Node[] getChild(Node parent) {

        Node first = null;
        Node second = null;

        int nextY = parent.y - 1;
        for (; nextY >= 0; nextY--) {
            if (!graph.get(nextY).isEmpty()) break;
        }

        if (nextY <= 0) return new Node[2];

        for (Node childNode : graph.get(nextY)) {
            if (childNode.x > parent.x) {
                if (first == null) {
                    first = childNode;
                    continue;
                }

                int firstGap = first.x - parent.x;
                int childGap = childNode.x - parent.x;

                if (childGap < firstGap) {
                    first = childNode;
                }
            } else {
                if (second == null) {
                    second = childNode;
                    continue;
                }

                int secondGap = parent.x - second.x;
                int childGap = parent.x - childNode.x;

                if (childGap < secondGap) {
                    second = childNode;
                }
            }
        }

        return new Node[]{first, second};
    }
}
