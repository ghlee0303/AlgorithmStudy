package back;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class s_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputSize; i++) {
            String[] testCaseInfo = br.readLine().split(" ");

            int documentSize = Integer.parseInt(testCaseInfo[0]);
            int targetIndex = Integer.parseInt(testCaseInfo[1]);

            String[] inputQueue = br.readLine().split(" ");
            Queue<Node> queue = new LinkedList<>();
            for (int j = 0; j < documentSize; j++) {
                Node node = new Node(inputQueue[j]);

                if (targetIndex == j) {
                    node.isTarget = true;
                }
                queue.add(node);
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                Node task = queue.poll();

                if (queue.stream().anyMatch(node -> node.priority > task.priority)) {
                    queue.add(task);
                } else {
                    printOrder++;

                    if (task.isTarget) {
                        break;
                    }
                }
            }
            bw.write(printOrder + "\n");
        }
        bw.flush();
    }

    public static class Node {
        int priority;
        boolean isTarget;

        public Node(String priority) {
            this.priority = Integer.parseInt(priority);
        }

        public boolean isUpper(Node node) {
            return this.priority > node.priority;
        }
    }
}
