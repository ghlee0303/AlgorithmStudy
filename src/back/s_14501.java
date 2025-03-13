package back;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class s_14501 {
    static int size;
    static List<Schedule> scheduleList;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        createScheduleList();

        int max = 0;
        for (int i = 0; i < size; i++) {
            int cost = calculate(i, 0);
            max = Math.max(cost, max);
        }

        bw.write(max + "\n");
        bw.flush();
    }

    private static int calculate(int start, int cost) {
        int max = 0;

        for (int i = start; i < size; i++) {
            Schedule schedule = scheduleList.get(i);

            int next = i + schedule.day;
            int costSum = cost;

            if (next < size) {
                costSum = cost + calculate(next, schedule.cost);
            } else if (next == size) {
                costSum = cost + schedule.cost;
            }
            max = Math.max(max, costSum);
        }

        return max;
    }

    private static void createScheduleList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        scheduleList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            scheduleList.add(new Schedule(br.readLine().split(" ")));
        }
    }

    static class Schedule {
        int day;
        int cost;

        public Schedule(String[] input) {
            this.day = Integer.parseInt(input[0]);
            this.cost = Integer.parseInt(input[1]);
        }
    }
}
