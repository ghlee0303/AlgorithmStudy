package back;

import java.io.*;
import java.util.Objects;

public class s_15721 {
    static int people;
    static int target;
    static boolean slogan;
    static int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        people = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        slogan = Objects.equals(br.readLine(), "1");

        game();

        int result = (count[0] + count[1]) % people - 1;

        if (result < 0) {
            result += people;
        }

        bw.write(result + "\n");
        bw.flush();
    }

    private static void game() {
        int index = 2;

        boolean nowSlogan;
        while (true) {
            for (int j = 0; j < 4; j++) {
                nowSlogan = j % 2 != 0;
                if (gameCount(nowSlogan)) return;
            }

            for (int j = 0; j < 2; j++) {
                nowSlogan = j % 2 != 0;

                for (int k = 0; k < index; k++) {
                    if (gameCount(nowSlogan)) return;
                }
            }

            index++;
        }
    }

    private static boolean gameCount(boolean nowSlogan) {
        if (nowSlogan) {
            ++count[1];
        } else {
            ++count[0];
        }

        if (slogan == nowSlogan) {
            int index = slogan ? 1 : 0;

            return target == count[index];
        }

        return false;
    }
}
