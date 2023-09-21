package back;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class s_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            String[] parts = br.readLine().split(" ");
            Integer[] sum = new Integer[parts.length-1];

            for (int j = 1; j < parts.length; j++) {
                int grade = Integer.parseInt(parts[j]);
                if (grade > max) {
                    max = grade;
                }
                if (grade < min) {
                    min = grade;
                }
                sum[j-1] = grade;
            }

            Arrays.sort(sum, Collections.reverseOrder());
            int largeGap = Integer.MIN_VALUE;
            for (int j = 0; j < sum.length - 1; j++) {
                int gap = sum[j] - sum[j+1];
                if (largeGap < gap) {
                    largeGap = gap;
                }
            }
            bw.write("Class " + (i+1) + "\n");
            bw.write("Max " + max + ", Min " + min + ", Largest gap " + largeGap + "\n");
        }
        bw.close();
    }
}
