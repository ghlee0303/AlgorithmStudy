package back;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s_15649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Integer> array = new ArrayList<>();
    static boolean[] visit;
    static int n, r;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        permutation(0);
        bw.flush();
    }

    public static void permutation(int depth) throws IOException {
        if (r == depth) {
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            array.add(i + 1);
            permutation(depth + 1);
            array.remove(array.size() - 1);
            visit[i] = false;
        }
    }

    public static void print() throws IOException {
        for (int i = 0; i < array.size(); i++) {
            bw.write(array.get(i) + " ");
        }
        bw.write("\n");
    }
}
