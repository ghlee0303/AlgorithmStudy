package back;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class s_17129 {
    static int[][] graph;
    static int maxX, maxY, startX, startY;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        createGraph();

        int value = bfs();

        if (value != 0) {
            System.out.println("TAK\n" + value);
        } else {
            System.out.println("NIE");
        }
    }

    private static int bfs() {
        boolean[][] visit = new boolean[maxY][maxX];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});

        visit[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int nowX = coordinate[0];
            int nowY = coordinate[1];
            int nowValue = coordinate[2];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (validationPoint(nextX, nextY)
                        || graph[nextY][nextX] == 1
                        || visit[nextY][nextX]) continue;

                if (graph[nextY][nextX] >= 3 && graph[nextY][nextX] <= 5) return nowValue + 1;

                visit[nextY][nextX] = true;
                queue.add(new int[]{nextX, nextY, nowValue + 1});
            }
        }

        return 0;
    }

    private static boolean validationPoint(int x, int y) {
        return (x < 0 || x >= maxX) || (y < 0 || y >= maxY);
    }

    private static void createGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        maxY = Integer.parseInt(parts[0]);
        maxX = Integer.parseInt(parts[1]);

        graph = new int[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            String[] edgeParts = br.readLine().split("");

            for (int j = 0; j < maxX; j++) {
                graph[i][j] = Integer.parseInt(edgeParts[j]);

                if (graph[i][j] == 2) {
                    startX = j;
                    startY = i;
                }
            }
        }
    }
}
