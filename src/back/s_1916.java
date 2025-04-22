package back;

import java.io.*;
import java.util.*;

public class s_1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int city, bus, startCity, endCity;
    static List<Edge>[] graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        createGraph();
        bw.write(solve() + "\n");
        bw.flush();
    }

    public static int solve() {
        boolean[] visit = new boolean[city];
        PriorityQueue<Edge> queue = new PriorityQueue<>(((o1, o2) -> o1.value - o2.value));

        queue.add(new Edge(startCity, 0));
        result[startCity] = 0;

        while (!queue.isEmpty()) {
            Edge nowEdge = queue.poll();
            if (nowEdge.node == endCity) return result[nowEdge.node];
            if (visit[nowEdge.node]) continue;
            visit[nowEdge.node] = true;

            for (Edge nextEdge : graph[nowEdge.node]) {
                int newValue = result[nowEdge.node] + nextEdge.value;
                if (result[nextEdge.node] < newValue) continue;

                result[nextEdge.node] = newValue;
                queue.add(new Edge(nextEdge.node, newValue));
            }
        }

        return result[endCity];
    }

    public static void createGraph() throws IOException {
        StringTokenizer st;
        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());

        graph = new List[city];
        result = new int[city];

        for (int i = 0; i < city; i++) {
            graph[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, value));
        }

        st = new StringTokenizer(br.readLine(), " ");
        startCity = Integer.parseInt(st.nextToken()) - 1;
        endCity = Integer.parseInt(st.nextToken()) - 1;
    }

    public static class Edge {
        int node;
        int value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
