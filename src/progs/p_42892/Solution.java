package progs.p_42892;

import java.util.*;

public class Solution {
    static class Node {
        int number, x, y;
        Node left, right;

        Node(int number, int x, int y) {
            this.number = number + 1;
            this.x = x;
            this.y = y;
        }
    }

    Node root;
    int[][] result;
    int preOrderIndex = 0;
    int inOrderIndex = 0;

    public int[][] solution(int[][] nodeInfo) {
        createNode(nodeInfo);
        result = new int[2][nodeInfo.length];

        preOrder(root);
        inOrder(root);

        return result;
    }

    private void createNode(int[][] nodeInfo) {
        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < nodeInfo.length; i++) {
            nodeList.add(new Node(i, nodeInfo[i][0], nodeInfo[i][1]));
        }

        nodeList.sort((a, b) -> b.y - a.y);
        root = nodeList.get(0);

        for (int i = 1; i < nodeInfo.length; i++) {
            insert(root, nodeList.get(i));
        }
    }

    private void insert(Node parent, Node node) {
        if (parent.x < node.x) {
            if (parent.right == null) parent.right = node;
            else insert(parent.right, node);
        } else {
            if (parent.left == null) parent.left = node;
            else insert(parent.left, node);
        }
    }

    private void preOrder(Node parent) {
        if (parent == null) return;

        result[0][preOrderIndex++] = parent.number;

        if (parent.left != null) preOrder(parent.left);
        if (parent.right != null) preOrder(parent.right);
    }

    private void inOrder(Node parent) {
        if (parent == null) return;

        if (parent.left != null) inOrder(parent.left);
        if (parent.right != null) inOrder(parent.right);

        result[1][inOrderIndex++] = parent.number;
    }
}
