package back;

import java.io.*;
import java.util.*;

public class s_2178 {
    static boolean[][] graph;
    static int xMax;
    static int yMax;

    public static void main(String[] args) throws IOException {
        createGraph();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(search()));
        bw.flush();
    }

    private static int search() {
        Queue<Coordinate> queue = new LinkedList<>();

        Coordinate now = new Coordinate(0, 0);
        queue.add(now);

        int[][] visited = new int[yMax][xMax];
        visited[now.y][now.x] = 1;

        while (!queue.isEmpty()) {
            now = queue.poll();

            List<Coordinate> nextCoordinates = createNextCoordinate(now.x, now.y);

            for (Coordinate next : nextCoordinates) {
                int nextX = next.x;
                int nextY = next.y;

                if (visited[nextY][nextX] == 0) {
                    visited[nextY][nextX] = visited[now.y][now.x] + 1;
                    queue.add(next);
                }

                if (nextY == yMax - 1 && nextX == xMax - 1) { // 목표지점 도착 시 즉시 반환
                    return visited[nextY][nextX];
                }
            }
        }

        return visited[yMax - 1][xMax - 1];
    }

    private static void createGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        yMax = Integer.parseInt(parts[0]);
        xMax = Integer.parseInt(parts[1]);

        graph = new boolean[yMax][xMax];

        for (int i = 0; i < yMax; i++) {
            String[] edgeParts = br.readLine().split("");

            int j = 0;
            for (String part : edgeParts) {
                graph[i][j] = part.equals("1");
                j++;
            }
        }
    }

    private static boolean getGraphValue(int x, int y) {
        return (x >= 0 && x < xMax && y >= 0 && y < yMax) && graph[y][x];
    }

    private static List<Coordinate> createNextCoordinate(int nowX, int nowY) {
        List<Coordinate> result = new ArrayList<>();

        // 이동 방향: 아래, 오른쪽, 위, 왼쪽
        List<int[]> directions = List.of(
                new int[]{0, 1},  // 아래
                new int[]{1, 0},  // 오른쪽
                new int[]{0, -1}, // 위
                new int[]{-1, 0}  // 왼쪽
        );

        for (int[] dir : directions) {
            int nextX = nowX + dir[0];
            int nextY = nowY + dir[1];

            if (getGraphValue(nextX, nextY)) {
                result.add(new Coordinate(nextX, nextY));
            }
        }

        return result;
    }


    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
