package back;

import java.io.*;
import java.util.*;

public class s_1260 {
    static Map<Integer, TreeSet<Integer>> graph;
    static LinkedHashSet<Integer> dfsResult = new LinkedHashSet<>();
    static LinkedHashSet<Integer> bfsResult = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        int startNode = createGraph();

        dfs(startNode);
        bfs(startNode);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        printResult(bw, dfsResult);
        printResult(bw, bfsResult);

        bw.flush();
        bw.close();
    }

    private static void dfs(int startNode) {
        if (!dfsResult.add(startNode)) {
            return;
        }

        TreeSet<Integer> graphEdgeSet = graph.get(startNode);
        if (graphEdgeSet == null || graphEdgeSet.isEmpty()) {
            return;
        }

        for (Integer nextNode : graphEdgeSet) {
            dfs(nextNode);
        }
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        bfsResult.add(startNode);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            TreeSet<Integer> graphEdgeSet = graph.get(node);
            if (graphEdgeSet == null || graphEdgeSet.isEmpty()) {
                continue;
            }

            for (Integer nextNode : graphEdgeSet) {
                if (bfsResult.add(nextNode)) {
                    queue.add(nextNode);
                }
            }
        }
    }

    private static int createGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        final int edge = Integer.parseInt(parts[1]);
        final int start = Integer.parseInt(parts[2]);

        graph = new HashMap<>();

        for (int i = 0; i < edge; i++) {
            String[] edgeParts = br.readLine().split(" ");
            int startNodeNumber = Integer.parseInt(edgeParts[0]);
            int endNodeNumber = Integer.parseInt(edgeParts[1]);

            graph.computeIfAbsent(startNodeNumber, k -> new TreeSet<>()).add(endNodeNumber);
            graph.computeIfAbsent(endNodeNumber, k -> new TreeSet<>()).add(startNodeNumber);
        }

        return start;
    }

    private static void printResult(BufferedWriter bw, LinkedHashSet<Integer> result) throws IOException {
        for (Integer node : result) {
            bw.write(node + " ");
        }
        bw.write("\n");
    }
}
