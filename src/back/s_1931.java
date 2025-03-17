package back;

import java.io.*;
import java.util.*;

public class s_1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Conference> conferenceList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        createList();
        int count = 0;
        int prevEnd = -1;

        for (Conference conference : conferenceList) {
            int end = conference.end;
            int start = conference.start;

            if (prevEnd <= start) {
                prevEnd = end;

                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
    }

    public static void createList() throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            int startInput = Integer.parseInt(parts[0]);
            int endInput = Integer.parseInt(parts[1]);

            conferenceList.add(new Conference(startInput, endInput));
        }

        Collections.sort(conferenceList);
    }

    public static class Conference implements Comparable<Conference> {
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            int compareEnd = Integer.compare(this.end, o.end);

            switch (compareEnd) {
                case 0: {
                    return Integer.compare(this.start, o.start);
                }
                case -1: {
                    return -1;
                }
                case 1: {
                    return 1;
                }
                default: {
                    return 0;
                }
            }
        }
    }
}
