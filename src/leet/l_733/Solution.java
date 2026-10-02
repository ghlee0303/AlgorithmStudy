package leet.l_733;

public class Solution {
    int[][] image;
    boolean[][] visited;
    int changeColor, originalColor, maxX, maxY;

    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.changeColor = color;
        this.originalColor = image[sr][sc];

        maxY = image.length;
        maxX = image[0].length;

        this.visited = new boolean[maxY][maxX];

        dfs(sc, sr);

        return image;
    }

    private void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= maxX || y >= maxY || image[y][x] != originalColor || visited[y][x]) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(nx, ny);
            image[y][x] = changeColor;
            visited[y][x] = true;
        }
    }
}
