package back;

import java.io.*;

public class s_13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long [] dp = new long[n + 4];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;

        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        bw.write(
                (dp[n] + dp[n - 1]) * 2 + 2 * dp[n] + "\n"
        );
        bw.flush();
    }
}
