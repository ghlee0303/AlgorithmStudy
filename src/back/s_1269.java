package back;

import java.io.*;
import java.util.*;

public class s_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        HashMap<Integer, Integer> a = new HashMap<>();
        parts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(parts[i]);
            a.put(t, t);
        }

        HashMap<Integer, Integer> b = new HashMap<>();
        parts = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(parts[i]);
            b.put(t, t);
        }

        br.close();
        int result = calc(a, b) + calc(b, a);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int calc(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b) {
        int result = 0;
        for (HashMap.Entry<Integer, Integer> entry : a.entrySet()) {
            if (b.get(entry.getKey()) == null)
                result++;
        }
        return result;
    }
}
