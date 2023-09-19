package back;

import java.io.*;
import java.math.BigInteger;

public class s_1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            int n = Integer.parseInt(input);

            BigInteger bigInteger = BigInteger.ZERO;
            for (int j = 0; j < n; j++) {
                input = br.readLine();
                bigInteger = bigInteger.add(new BigInteger(input));
            }

            int compareTo = bigInteger.compareTo(BigInteger.ZERO);

            if (compareTo == 0) {
                bw.write("0"+"\n");
            } else if (compareTo < 0) {
                bw.write("-"+"\n");
            } else {
                bw.write("+"+"\n");
            }
            bw.flush();
        }
        bw.close();
    }
}
