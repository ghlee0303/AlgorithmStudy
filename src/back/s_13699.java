package back;

import java.io.*;

public class s_13699 {
    static long[] dp = new long[37];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;

            if (i % 2 == 1) {
                dp[i] += (dp[i / 2] * dp[i / 2]) + childSum(i);
            } else {
                dp[i] += childSum(i);
            }
        }

        bw.write(dp[n] + "\n");
        bw.flush();
    }

    public static long childSum(int i) {
        int first = 0;
        int second = i - 1;

        long sum = 0;

        while (first < second) {
            sum += (dp[first] * dp[second]) * 2;

            first++;
            second--;
        }

        return sum;
    }
}
