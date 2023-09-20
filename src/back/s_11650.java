package back;

import java.io.*;

public class s_11650 {
    static class Data {
        public int x;
        public int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Data[] data = new Data[n];

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            data[i] = new Data(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        for (Data d : sort(data)) {
            bw.write(d.x + " " + d.y + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    public static Data[] sort(Data[] numbers) {
        int length = numbers.length;
        if (length == 1) {
            return numbers;
        }
        int halfIndex = length / 2;
        int secondIndex = length - halfIndex;
        Data[] first = new Data[halfIndex];
        Data[] second = new Data[secondIndex];

        for (int i = 0; i < halfIndex; i++) {
            first[i] = numbers[i];
        }
        for (int i = 0; i < secondIndex; i++) {
            second[i] = numbers[length-secondIndex+i];
        }

        Data[] data1 = sort(first);
        Data[] data2 = sort(second);

        return merge(data1, data2);
    }

    public static Data[] merge(Data[] data1, Data[] data2) {
        int n1 = data1.length;
        int k1 = 0;
        int n2 = data2.length;
        int k2 = 0;
        int k = n1 + n2;
        Data[] result = new Data[k];

        int i = 0;
        while (k1 < n1 && k2 < n2) {
            int compare1 = data1[k1].x;
            int compare2 = data2[k2].x;

            if (compare1 == compare2) {
                compare1 =  data1[k1].y;
                compare2 =  data2[k2].y;
            }

            if (compare1 < compare2) {
                result[i] = data1[k1];
                k1++;
            } else {
                result[i] = data2[k2];
                k2++;
            }
            i++;
        }

        for (int j = i; j < k; j++) {
            if (k1 < n1) {
                result[j] = data1[k1];
                k1++;
            } else if (k2 < n2) {
                result[j] = data2[k2];
                k2++;
            }
        }

        return result;
    }
}
