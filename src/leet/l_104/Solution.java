package leet.l_104;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {

        return dfs(root, 1);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) return depth - 1;

        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }
}