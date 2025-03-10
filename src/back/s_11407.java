package back;

import java.io.*;

public class s_11407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int coinSize = Integer.parseInt(input[0]);
        int cash = Integer.parseInt(input[1]);

        int[] coins = new int[coinSize];

        for (int i = 0; i < coinSize; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int remainCash = cash;
        int coinCount = 0;

        for (int i = coinSize - 1; i >= 0; i--) {
            int targetCoin = coins[i];

            coinCount += remainCash / targetCoin;
            remainCash %= targetCoin;
        }

        bw.write(coinCount + "");
        bw.flush();
    }
}
