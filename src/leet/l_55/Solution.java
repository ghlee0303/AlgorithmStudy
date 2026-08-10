package leet.l_55;

/**
 *
 */

public class Solution {
    boolean[] visited;
    int[] array;

    public boolean canJump(int[] nums) {
        visited = new boolean[nums.length + 1];
        array = nums;

        return jump(0);
    }

    private boolean jump(int start) {
        int maxJump = array[start];

        if (array.length == start + 1) return true;

        for (int i = 1; i <= maxJump; i++) {
            int next = i + start;

            if (visited[next]) continue;

            if (jump(next)) {
                return true;
            } else {
                visited[start] = true;
            }
        }

        return false;
    }
}
