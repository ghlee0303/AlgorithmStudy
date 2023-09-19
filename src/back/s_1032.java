package back;

import java.io.*;

public class s_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int n = Integer.parseInt(input);

        String[] cmds = new String[n];
        for (int i = 0; i < n; i++) {
            cmds[i] = br.readLine();
        }

        if (n == 1) {
            bw.write(cmds[0]);
            bw.flush();
            bw.close();
            return;
        }

        int k = cmds[0].length();
        char[] result = cmds[0].toCharArray();
        for (int i = 1; i < n; i++) {
            char[] cmd1 = cmds[i-1].toCharArray();
            char[] cmd2 = cmds[i].toCharArray();
            for (int j = 0; j < k; j++) {
                if (!(cmd1[j] == cmd2[j])) {
                    result[j] = '?';
                }
            }
        }
        bw.write(result);
        bw.flush();
        bw.close();
    }
}
