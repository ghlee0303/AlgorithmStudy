package progs.p_12946;

/**
 * 프로그래머스 하노이의 탑
 * 해설보고함
 */

public class Solution {
    int[][] result;
    int index = 0;

    public int[][] solution(int n) {
        int max = (int) Math.pow(2, n);
        result = new int[max - 1][2];

        hanoi(n, 1, 3, 2);

        return result;
    }

    private void hanoi(int value, int start, int end, int sub) {    // 2 A C B
        if (value == 1) {
            input(start, end);
            return;
        }

        hanoi(value - 1, start, sub, end);      // 1 A B C
        input(start, end);
        hanoi(value - 1, sub, end, start);
    }

    private void input(int start, int end) {
        result[index][0] = start;
        result[index][1] = end;
        index++;
    }
}
