package progs.p_140107;

/**
 * 프로그래머스 점 찍기
 * 해설보고함
 */

public class Solution {
    public long solution(int k, int d) {
        long count = 0;

        for (double i = 0; i <= d; i += k) {
            long maxY = (long) Math.sqrt(d * d - i * i);

            count += maxY / k + 1;
        }

        return count;
    }
}
