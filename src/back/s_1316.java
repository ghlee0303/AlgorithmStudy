package back;

import java.io.*;
import java.util.HashMap;

public class s_1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (solve(input)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean solve(String input) {
        char prevC = '\0';
        HashMap<Character, Boolean> isVisited = new HashMap<>();

        for (char targetC : input.toCharArray()) {
            if (targetC != prevC) {
                if (isVisited.getOrDefault(targetC, false))
                    return false;

                isVisited.put(targetC, true);
            }
            prevC = targetC;

        }

        return true;
    }
}
