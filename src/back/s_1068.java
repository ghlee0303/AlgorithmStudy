package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s_1068 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static int targetNode;
    static int rootNode;

    public static void main(String[] args) throws IOException {
        createTree();

        int value = 0;
        if (targetNode != rootNode) {
            value = counting(rootNode);
        }

        System.out.println(value);
    }

    public static int counting(int node) {
        List<Integer> children = tree.get(node);
        if (children == null || children.isEmpty()) return 1;
        if (children.size() == 1 && children.contains(targetNode)) return 1;

        int count = 0;
        for (int child : children) {
            if (child == targetNode) continue;
            count += counting(child);
        }

        return count;
    }

    public static void createTree() throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input != -1) {
                tree.get(input).add(i);
            } else {
                rootNode = i;
            }
        }

        targetNode = Integer.parseInt(br.readLine());
    }
}
