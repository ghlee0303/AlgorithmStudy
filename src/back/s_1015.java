package back;

import java.io.*;

public class s_1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int w = 8;
        int h = 8;

        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            board[i] = input.toCharArray();
        }

        int min = Integer.MAX_VALUE;
        for (int u = 0; u < 2; u++) {
            for (int k = 0; k <= n - h; k++) {
                for (int i = 0; i <= m - w; i++) {
                    int count = 0;
                    char current;
                    for (int l = k; l < h + k; l++) {
                        for (int j = i; j < w + i; j++) {
                            current = BorW(u, j+l);
                            char now = board[l][j];
                            if (current == now) {
                                count++;
                            }
                        }
                    }
                    min = Math.min(count, min);
                }
            }
        }
        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
    }

    private static char BorW(int u, int j) {
        boolean isEvenJ = j % 2 == 0;

        switch (u) {
            case 0:
                return isEvenJ ? 'B' : 'W';
            case 1:
                return isEvenJ ? 'W' : 'B';
            default:
                return 0;
        }
    }


}
