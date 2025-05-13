package back;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class s_15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int targetCount, minResult = Integer.MAX_VALUE;
    static List<Coordinate> homeList = new ArrayList<>();
    static List<Coordinate> chickenList = new ArrayList<>();
    static List<Coordinate> current = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int size = Integer.parseInt(st.nextToken());
        targetCount = Integer.parseInt(st.nextToken());

        createList(size);

        backtracking(0, 0);

        bw.write(minResult + "");
        bw.flush();
    }

    public static void createList(int size) throws IOException {
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                int value = Integer.parseInt(st.nextToken());

                switch (value) {
                    case 1: {
                        homeList.add(new Coordinate(i, j));
                        break;
                    }
                    case 2: {
                        chickenList.add(new Coordinate(i, j));
                        break;
                    }
                }
            }
        }
    }

    public static void backtracking(int start, int depth) {
        if (depth == targetCount) {
            solve();
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            current.add(chickenList.get(i));
            backtracking(i + 1, depth + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void solve() {
        int[] minDistanceList = new int[homeList.size()];

        for (int i = 0; i < targetCount; i++) {
            Coordinate chicken = current.get(i);
            for (int j = 0; j < homeList.size(); j++) {
                int distance = chicken.distance(homeList.get(j));

                if (minDistanceList[j] == 0) {
                    minDistanceList[j] = distance;
                } else {
                    minDistanceList[j] = Math.min(minDistanceList[j],
                            chicken.distance(homeList.get(j)));
                }
            }
        }

        minResult = Math.min(minResult,
                Arrays.stream(minDistanceList).sum());
    }

    public static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Coordinate coordinate) {
            return Math.abs(this.x - coordinate.x) + Math.abs(this.y - coordinate.y);
        }
    }
}
