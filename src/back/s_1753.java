package back;

import java.io.*;
import java.util.*;

public class s_1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Edge>[] graph;
    static int[] result;
    static int nodeSize, edgeSize, startNode;

    public static void main(String[] args) throws IOException {
        createGraph();
        dijkstra();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < nodeSize; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(result[i] + "\n");
            }
        }

        bw.flush();
    }

    public static void dijkstra() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        boolean[] visit = new boolean[nodeSize];

        queue.add(new Edge(startNode, 0));
        result[startNode] = 0;

        while (!queue.isEmpty()) {
            Edge nowEdge = queue.poll();
            if (visit[nowEdge.node]) continue;
            visit[nowEdge.node] = true;

            for (Edge nextEdge : graph[nowEdge.node]) {
                if (visit[nextEdge.node]) continue;

                int newValue = result[nowEdge.node] + nextEdge.value;
                if (result[nextEdge.node] < newValue) continue;
                result[nextEdge.node] = newValue;

                queue.add(new Edge(nextEdge.node, newValue));
            }
        }
    }

    public static void createGraph() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nodeSize = Integer.parseInt(st.nextToken());
        edgeSize = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(br.readLine()) - 1;

        graph = new ArrayList[nodeSize];
        result = new int[nodeSize];

        for (int i = 0; i < nodeSize; i++) {
            result[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, value));
        }
    }

    static class Edge {
        int node;
        int value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
