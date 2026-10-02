package leet.l_695;

public class Solution {
    int[][] grid;
    int maxX, maxY;
    int WATER = 0;

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.maxY = grid.length;
        this.maxX = grid[0].length;

        int max = 0;
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (grid[y][x] == WATER) continue;

                int dfsValue = dfs(x, y, 0);
                max = Math.max(max, dfsValue);
            }
        }

        return max;
    }

    private int dfs(int x, int y, int count) {
        if (x < 0 || y < 0 || x >= maxX || y >= maxY || grid[y][x] == WATER) return count;

        grid[y][x] = WATER;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            count = dfs(nx, ny, count);
        }
        return count + 1;
    }
}