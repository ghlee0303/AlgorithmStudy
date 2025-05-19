package back;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s_15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, r;
    static List<Integer> array = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        combination(0);

        bw.flush();
    }

    public static void combination(int start) throws IOException {
        if (array.size() == r) {
            print();
            return;
        }

        for (int i = start; i < n; i++) {
            array.add(i + 1);
            combination(i + 1);
            array.remove(array.size() - 1);
        }
    }

    public static void print() throws IOException {
        for (int i = 0; i < array.size(); i++) {
            bw.write(array.get(i) + " ");
        }
        bw.write("\n");
    }
}
