package swe.s_4874;

import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static List<Integer> queue;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            queue = new ArrayList<>();
            List<String> inputList = new ArrayList<>();

            while (true) {
                String input = sc.next();
                inputList.add(input);
                if (input.equals(".")) break;
            }

            System.out.println("#" + tc + " " + queueing(inputList));
        }
    }

    private static String queueing(List<String> inputList) {
        for (String input : inputList) {
            if (input.equals(".")) break;

            if (isInt(input)) {
                queue.add(Integer.parseInt(input));
                continue;
            }

            if (queue.size() < 2) return "error";

            int result = calculate(input);

            queue.add(result);
        }

        if (queue.size() != 1) return "error";

        return String.valueOf(queue.get(0));
    }

    private static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int calculate(String input) {
        int first = queue.remove(queue.size() - 1);
        int second = queue.remove(queue.size() - 1);

        switch (input) {
            case "+": {
                return first + second;
            }
            case "-": {
                return first - second;

            }
            case "*": {
                return first * second;
            }
            case "/": {
                return first / second;
            }
            default: {
                return 0;
            }
        }
    }
}
