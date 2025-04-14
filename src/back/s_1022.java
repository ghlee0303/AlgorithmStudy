package back;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class s_1022 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] start, end;
    static int xMax, yMax;
    static int xPrefix, yPrefix;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        input();

        int maxLength = solution();
        for (int i = 0; i < xMax; i++) {
            sb.setLength(0);
            for (int j = 0; j < yMax; j++) {
                String value = String.format("%" + maxLength + "d ", result[i][j]);

                sb.append(value);
            }
            bw.write(sb + "\n");
        }

        bw.flush();
    }

    public static int solution() {
        int maxLength = 0;

        for (int i = start[0]; i <= end[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++) {
                int value = getSpiralValue(i, j);
                int length = (int) (Math.log10(value) + 1);

                maxLength = max(maxLength, length);

                result[i + xPrefix][j + yPrefix] = value;
            }
        }

        return maxLength;
    }

    public static int getSpiralValue(int x, int y) {
        int s = Math.max(Math.abs(x), Math.abs(y));  // shell level
        int minVal = (int) (pow((2 * s - 1), 2) + 1);       // shell의 마지막 값
        int length = 2 * s;                           // shell 한 변의 길이
        int offset = s - 1;

        if (x > 0 && (x == y)) {
            s++;
        }

        if (y == s) {
            return minVal + offset - x;
        } else if (x == -s) {
            return length + minVal + offset - y;
        } else if (y == -s) {
            return length * 2 + minVal + offset + x;
        } else { // x == s
            return length * 3 + minVal + offset + y;
        }
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        xPrefix = min(start[0], end[0]) * -1;
        yPrefix = min(start[1], end[1]) * -1;

        xMax = end[0] - start[0] + 1;
        yMax = end[1] - start[1] + 1;

        result = new int[xMax][yMax];
    }
}
