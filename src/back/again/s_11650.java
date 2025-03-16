package back.again;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class s_11650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<Integer>> tempMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            List<Integer> array = tempMap.computeIfAbsent(x, k -> new ArrayList<>());
            array.add(y);
            tempMap.put(x, array);
        }

        br.close();

        for (Integer x : tempMap.keySet()) {
            List<Integer> array = tempMap.get(x);
            Collections.sort(array);

            for (Integer y : array) {
                bw.write(x + " " + y + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
