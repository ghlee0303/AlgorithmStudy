package leet.l_200;

public class Solution {
    char[][] grid;
    boolean[][] visited;
    int maxX, maxY;
    char WATER = '0';

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.maxY = grid.length;
        this.maxX = grid[0].length;
        this.visited = new boolean[maxY][maxX];

        int count = 0;
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (visited[y][x]) continue;
                char value = grid[y][x];
                if (value == WATER) continue;

                dfs(x, y);
                count++;
            }
        }

        return count;
    }

    private void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= maxX || y >= maxY || visited[y][x] || grid[y][x] == WATER) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(nx, ny);
            visited[y][x] = true;
        }
    }
}