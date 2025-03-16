package back;

import java.io.*;

public class s_2839 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 6];
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;

            if (dp[i - 3] != -1) {
                first = dp[i - 3] + 1;
            }

            if (dp[i - 5] != -1) {
                second = dp[i - 5] + 1;
            }

            if (first == second && first == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = Math.min(first, second);
            }
        }

        bw.write(dp[n] + "\n");
        bw.flush();
    }
}
