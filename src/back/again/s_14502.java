package back.again;

import java.io.*;
import java.util.*;

public class s_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static Queue<Coordinate> virusStart = new LinkedList<>();
    static int safeCount = 0;
    static int maxY, maxX, maxResult;

    public static void main(String[] args) throws IOException {
        createGraph();
        createWall(0, 0);

        System.out.println(maxResult);
    }

    private static void createGraph() throws IOException {
        st = new StringTokenizer(br.readLine());

        maxY = Integer.parseInt(st.nextToken());
        maxX = Integer.parseInt(st.nextToken());

        graph = new int[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < maxX; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;

                switch (value) {
                    case 0: safeCount++; break;
                    case 2: virusStart.add(new Coordinate(j, i));
                }
            }
        }
    }

    private static void createWall(int count, int coordinateIndex) {
        if (count >= 3) {
            int[][] solveGraph = copyGraph();
            maxResult = Math.max(safeCount - 3 - spreadVirusBFS(solveGraph), maxResult);

            return;
        }

        for (; coordinateIndex < maxY * maxX; coordinateIndex++) {
            int nowY = coordinateIndex / maxX;
            int nowX = coordinateIndex % maxX;

            int value = graph[nowY][nowX];

            if (value != 0) {
                continue;
            }

            graph[nowY][nowX] = 1;
            createWall(++count, coordinateIndex + 1);
            graph[nowY][nowX] = 0;
            --count;
        }
    }

    private static int spreadVirusBFS(int[][] solveGraph) {
        Queue<Coordinate> queue = new LinkedList<>(virusStart);

        int virusCount = 0;
        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            switch (solveGraph[now.y][now.x]) {
                case 1 : continue;
                case 0: {
                    solveGraph[now.y][now.x] = 2;
                    virusCount++;
                }
            }
            queue.addAll(now.calculateNextBfs(maxX, maxY,
                    (nextX, nextY) -> bfsValidation(nextX, nextY, solveGraph))
            );
        }

        return virusCount;
    }

    private static boolean bfsValidation(int nextX, int nextY, int[][] solveGraph) {
        return solveGraph[nextY][nextX] != 0;
    }

    private static int[][] copyGraph() {
        int[][] copyGraph = new int[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            System.arraycopy(graph[i], 0, copyGraph[i], 0, maxX);
        }

        return copyGraph;
    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public List<Coordinate> calculateNextBfs(int maxX, int maxY, Validation validation) {
            final int[][] templateList = {
                    {0, 1},         // 오른쪽
                    {0, -1},         // 왼쪽
                    {1, 0},         // 위
                    {-1, 0},        // 아래
            };

            List<Coordinate> nextCoordinateList = new ArrayList<>();
            for (int[] template : templateList) {
                int nextX = template[0] + this.x;
                int nextY = template[1] + this.y;

                if (coordinateValidate(nextX, nextY, maxX, maxY)) continue;
                if (validation.bfs(nextX, nextY)) continue;

                nextCoordinateList.add(new Coordinate(nextX, nextY));
            }

            return nextCoordinateList;
        }

        private boolean coordinateValidate(int x, int y, int maxX, int maxY) {
            return x < 0 || y < 0 || x >= maxX || y >= maxY;
        }

        private interface Validation {
            boolean bfs(int nextX, int nextY);
        }
    }

}
