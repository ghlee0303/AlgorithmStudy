package back;

import java.io.*;
import java.util.StringTokenizer;

public class s_9465 {
    static int[][] graph;
    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            createGraph();
            bw.write(solve() + "\n");
        }

        br.close();
        bw.flush();
    }

    private static int solve() {
        int[][] dp = new int[2][size + 1];
        dp[1][1] = graph[1][1];
        dp[0][1] = graph[0][1];

        for (int i = 2; i <= size; i++) {
            dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + graph[0][i];
            dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + graph[1][i];
        }

        return Math.max(dp[1][size], dp[0][size]);
    }

    private static void createGraph() throws IOException {
        // 새로운 그래프 크기 읽기
        size = Integer.parseInt(br.readLine());

        // 기존 배열을 참조 해제하여 GC 대상이 되도록 함
        graph = null;
        graph = new int[2][size + 1];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= size; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}


