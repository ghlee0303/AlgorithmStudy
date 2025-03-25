package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    static List<Coordinate> virus = new ArrayList<>();
    static int maxX, maxY = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        createGraph();

        int max = solve();

        System.out.println(max);
    }

    private static int solve() {
        int size = maxX * maxY;
        int max = 0;

        for (int i = 0; i < size - 2; i++) {
            int firstY = i / maxX;
            int firstX = i % maxX;

            if (graph[firstY][firstX] != 0) continue;

            for (int j = i + 1; j < size - 1; j++) {
                int secondY = j / maxX;
                int secondX = j % maxX;

                if (graph[secondY][secondX] != 0) continue;

                for (int k = j + 1; k < size; k++) {
                    int thirdY = k / maxX;
                    int thirdX = k % maxX;

                    if (graph[thirdY][thirdX] != 0) continue;

                    int[][] solveGraph = initSolveGraph();

                    solveGraph[firstY][firstX] = 1;
                    solveGraph[secondY][secondX] = 1;
                    solveGraph[thirdY][thirdX] = 1;

                    max = Math.max(max, bfs(solveGraph));
                }
            }
        }

        return max;
    }

    private static int[][] initSolveGraph() {
        int[][] solveGraph = new int[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            solveGraph[i] = graph[i].clone();
        }

        return solveGraph;
    }

    private static int bfs(int[][] solveGraph) {
        Queue<Coordinate> queue = new LinkedList<>(virus);

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                if (solveGraph[coordinate.y][coordinate.x] == 1) continue;

                int nextX = coordinate.x + dx[i];
                int nextY = coordinate.y + dy[i];

                if (validationNextCoordinate(nextX, nextY)) continue;
                if (solveGraph[nextY][nextX] != 0) continue;

                solveGraph[nextY][nextX] = 2;
                queue.add(new Coordinate(nextX, nextY));
            }
        }

        return countSafe(solveGraph);
    }

    private static int countSafe(int[][] solveGraph) {
        int count = 0;

        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (solveGraph[i][j] == 0)
                    count++;
            }
        }

        return count;
    }

    private static boolean validationNextCoordinate(int nextX, int nextY) {
        return nextX < 0 || nextY < 0 || nextX >= maxX || nextY >= maxY;
    }

    private static void createGraph() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        maxY = Integer.parseInt(st.nextToken());
        maxX = Integer.parseInt(st.nextToken());

        graph = new int[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < maxX; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;

                if (value == 2) virus.add(new Coordinate(j, i));
            }
        }
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
