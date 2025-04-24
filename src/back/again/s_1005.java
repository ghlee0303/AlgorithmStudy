package back.again;

import java.io.*;
import java.util.*;

public class s_1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            bw.write(solve() + "\n");
        }

        bw.flush();
    }

    public static int solve() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        SolveData solveData = new SolveData(nodeSize);
        createBuildTimes(solveData, nodeSize);
        createBuildOrder(solveData, edgeSize);

        Queue<Integer> queue = new LinkedList<>();
        int target = Integer.parseInt(br.readLine()) - 1;
        int[] result = new int[nodeSize];

        for (int i = 0; i < nodeSize; i++) {
            result[i] = solveData.buildTime[i];

            if (solveData.inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            List<Integer> children = solveData.buildOrder[parent];

            for (int child : children) {
                result[child] = Math.max(result[child], result[parent] + solveData.buildTime[child]);
                solveData.inDegree[child] -= 1;

                if (solveData.inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }

        return result[target];
    }

    public static void createBuildTimes(SolveData solveData, int nodeSize) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < nodeSize; i++) {
            solveData.addBuildTime(i, Integer.parseInt(st.nextToken()));
        }
    }

    public static void createBuildOrder(SolveData solveData, int edgeSize) throws IOException {
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            solveData.addBuildOrder(start, end);
        }
    }

    public static class SolveData {
        List<Integer>[] buildOrder;
        int[] buildTime, inDegree;

        public SolveData(int nodeSize) {
            buildOrder = new List[nodeSize];
            buildTime = new int[nodeSize];
            inDegree = new int[nodeSize];
        }

        public void addBuildTime(int i, int time) {
            buildTime[i] = time;
            buildOrder[i] = new ArrayList<>();
        }

        public void addBuildOrder(int start, int end) {
            start--;
            end--;
            buildOrder[start].add(end);
            inDegree[end]++;
        }
    }
}
