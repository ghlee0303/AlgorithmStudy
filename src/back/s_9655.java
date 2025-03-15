package back;

import java.io.*;

public class s_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 4; i <= inputSize; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }

        bw.write(
                dp[inputSize] % 2 == 1 ? "SK" : "CY"
        );
        bw.flush();
    }
}
