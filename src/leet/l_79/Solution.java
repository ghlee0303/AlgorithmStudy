package leet.l_79;

public class Solution {
    char firstWord;
    char[] wordArray;
    boolean[][] visited;
    int n, m;
    char[][] board;

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        wordArray = word.toCharArray();
        firstWord = wordArray[0];
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        this.board = board;

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (dfs(x, y, 0)) return true;
                visited = new boolean[m][n];
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int index) {
        if (index >= wordArray.length) return true;
        if (x < 0 || y < 0 || x >= n || y >= m) return false;

        char boardWord = board[y][x];
        char targetWord = wordArray[index];
        if (boardWord != targetWord || visited[y][x]) return false;

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (dfs(nx, ny, index + 1)) return true;
        }
        visited[y][x] = false;

        return false;
    }
}
