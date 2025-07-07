package back;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_10815 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static int[] haveList;
    static int[] compareList;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        haveList = createList(n);
        Arrays.sort(haveList);

        m = Integer.parseInt(br.readLine());
        compareList = createList(m);

        for (int i = 0; i < m; i++) {
            int compareValue = compareList[i];

            if (binarySearch(compareValue)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
    }

    public static boolean binarySearch(int compareValue) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int targetValue = haveList[mid];

            if (targetValue < compareValue) {
                start = mid + 1;
            } else if (targetValue > compareValue) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int[] createList(int n) throws IOException {
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        return array;
    }
}
