package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] parts = input.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        int w = Integer.parseInt(parts[2]);
        int h = Integer.parseInt(parts[3]);

        int minX = Math.min(x, Math.abs(x - w));
        int minY = Math.min(y, Math.abs(y - h));


        System.out.println(Math.min(minX, minY));
    }
}
