package back;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class s_1005 {
    static int[] node;
    static HashMap<Integer, List<Integer>> map;
    static HashMap<Integer, Integer> memo;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            createNodeMap();
            int target = Integer.parseInt(br.readLine());
            memo = new HashMap<>();

            bw.write(solve(target) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int parent) {
        int value = memo.getOrDefault(parent, -1);

        if (value != -1) return value;

        List<Integer> children = map.get(parent);

        if (children == null || children.isEmpty()) {
            memo.put(parent, node[parent]);
            return node[parent];
        }

        int maxChild = 0;
        int maxChildValue = 0;
        for (int child : children) {
            int solveValue = solve(child);
            if (maxChildValue < solveValue) {
                maxChild = child;
                maxChildValue = solveValue;
            }
        }

        memo.put(maxChild, maxChildValue);
        int parentValue = node[parent] + maxChildValue;
        memo.put(parent, parentValue);

        return parentValue;
    }

    public static void createNodeMap() throws IOException {
        StringTokenizer maxSt = new StringTokenizer(br.readLine(), " ");

        int nodeMax = Integer.parseInt(maxSt.nextToken());
        int mapMax = Integer.parseInt(maxSt.nextToken());

        StringTokenizer nodeSt = new StringTokenizer(br.readLine(), " ");
        node = null;
        node = new int[nodeMax + 1];
        for (int i = 1; i <= nodeMax; i++) {
            node[i] = Integer.parseInt(nodeSt.nextToken());
        }

        map = null;
        map = new HashMap<>();
        for (int i = 0; i < mapMax; i++) {
            StringTokenizer mapSt = new StringTokenizer(br.readLine(), " ");
            int child = Integer.parseInt(mapSt.nextToken());
            int parent = Integer.parseInt(mapSt.nextToken());

            List<Integer> childList = map.computeIfAbsent(parent, k -> new ArrayList<>());
            childList.add(child);
        }
    }
}
