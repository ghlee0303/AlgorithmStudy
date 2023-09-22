package back;

import java.io.*;

public class s_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = br.readLine().split(" ");
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);

        if (x > y) {
            int temp = y;
            y = x;
            x = temp;
        }

        bw.write(String.valueOf(divide(x, y, 1)));
        bw.flush();
        bw.close();
    }

    public static int divide(int x, int y, int count) {
        if ( ((x%2 == 1) && (x+1 == y)) ) {
            return count;
        }
        x = x/2 + x%2;
        y = y/2 + y%2;
        return divide(x, y, ++count);
    }
}
