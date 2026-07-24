package progs.p_12938;

import java.util.*;

/**
 * 프로그래머스 최고의 집합
 *
 * 2026 07 24
 */
public class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int[] result = new int[n];

        int value = s / n;
        int remainder = s % n;

        for (int i = 0; i < n; i++) {
            if (i < remainder) {
                result[i] = value + 1;
            } else {
                result[i] = value;
            }
        }
        Arrays.sort(result);

        return result;
    }
}
