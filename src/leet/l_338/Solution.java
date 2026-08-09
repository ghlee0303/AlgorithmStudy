package leet.l_338;

public class Solution {
    int[] result;

    public int[] countBits(int n) {
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            bit(i);
        }

        return result;
    }

    private void bit(int value) {
        int exp = exponent(value);
        int group = (int) Math.pow(2, exp);
        int other = result[value - group];

        if (group - value == 0) {
            result[value] = 1;
        } else {
            result[value] = result[group] + other;
        }
    }

    private int exponent(int value) {
        return 31 - Integer.numberOfLeadingZeros(value);
    }
}
