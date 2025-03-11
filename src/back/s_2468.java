package back;

import java.io.*;
import java.util.*;

public class s_2468 {
    static int[][] area;
    static int max = 0;
    static int areaSize;
    static boolean[][] visited;
    // 이동 방향: 아래, 오른쪽, 위, 왼쪽
    static final List<int[]> directions = List.of(
            new int[]{0, 1},  // 아래
            new int[]{1, 0},  // 오른쪽
            new int[]{0, -1}, // 위
            new int[]{-1, 0}  // 왼쪽
    );

    public static void main(String[] args) throws IOException {
        createArea();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int maxSafeArea = raining();

        bw.write(maxSafeArea + "");
        bw.flush();
    }

    private static void createArea() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int size = Integer.parseInt(br.readLine());

        areaSize = size;
        area = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                area[i][j] = Integer.parseInt(input[j]);
                max = Math.max(max, area[i][j]);
            }
        }

        br.close();
    }

    private static int raining() {
        int maxSafeArea = 0;

        visited = new boolean[areaSize][areaSize];
        for (int rain = 0; rain <= max; rain++) {
            int count = getSafeArea(rain);
            maxSafeArea = Math.max(maxSafeArea, count);
        }

        return maxSafeArea;
    }

    private static int getSafeArea(int rain) {
        int count = 0;

        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        for (int y = 0; y < areaSize; y++) {
            for (int x = 0; x < areaSize; x++) {
                if (!visited[y][x] && area[y][x] > rain) {
                    dfs(x, y, rain);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int startX, int startY, int rain) {
        visited[startY][startX] = true;

        for (int[] dir : directions) {
            int nextX = startX + dir[0];
            int nextY = startY + dir[1];

            if (validateCoordinate(nextX, nextY)
                    && area[nextY][nextX] > rain
                    && !visited[nextY][nextX]) {
                dfs(nextX, nextY, rain);
            }
        }
    }

    private static boolean validateCoordinate(int x, int y) {
        return (x >= 0 && y >= 0
                && x < areaSize && y < areaSize);
    }
}
