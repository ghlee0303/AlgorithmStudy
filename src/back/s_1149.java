package back;

import java.io.*;

public class s_1149 {
    static int[][] RGB;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        createRGB();
        int result = solution();

        bw.write(result + "\n");
        bw.flush();
    }

    private static int solution() {
        // 두 번째 라인부터 검사
        for (int j = 1; j < size; j++) {
            int[] costArray = RGB[j - 1];

            RGB[j][0] += Math.min(costArray[1], costArray[2]);
            RGB[j][1] += Math.min(costArray[0], costArray[2]);
            RGB[j][2] += Math.min(costArray[0], costArray[1]);
        }

        int[] resultArray = RGB[size - 1];
        return Math.min(resultArray[0], Math.min(resultArray[1], resultArray[2]));
    }

    private static void createRGB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        RGB = new int[size][3];
        for (int i = 0; i < size; i++) {
            String[] parts = br.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(parts[j]);
            }
        }
    }
}
