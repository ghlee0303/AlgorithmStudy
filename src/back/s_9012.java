package back;

import java.io.*;
import java.util.LinkedList;

public class s_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputSize; i++) {
            String[] parts = br.readLine().split("");

            bw.write(vpsStack(parts) ? "YES" : "NO");
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean vpsStack(String[] parts) {
        Stack stack = new Stack();

        for (String part : parts) {
            if (part.equals("(")) {
                stack.add(part);
            } else if (part.equals(")")) {
                if (stack.size <= 0) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.size == 0;
    }

    static class Stack {
        private final LinkedList<String> values;
        int size;

        public Stack() {
            values = new LinkedList<>();
            size = 0;
        }

        public void add(String value) {
            values.add(value);
            size++;
        }

        public String pop() {
            String result = values.remove(size - 1);
            size--;
            return result;
        }
    }
}
