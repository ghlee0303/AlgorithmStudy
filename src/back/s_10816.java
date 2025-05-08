package back;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_10816 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] array;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            bw.write(binaryUpper(n, target) - binaryLower(n, target) + " ");
        }

        bw.flush();
    }

    public static int binaryLower(int size, int target) {
        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int half = (start + end) / 2;
            int halfValue = array[half];

            if (halfValue < target) {
                start = half + 1;
            } else {
                end = half - 1;
            }
        }

        return start;
    }

    public static int binaryUpper(int size, int target) {
        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int half = (start + end) / 2;
            int halfValue = array[half];

            if (halfValue <= target) {
                start = half + 1;
            } else {
                end = half - 1;
            }
        }

        return start;
    }
}
