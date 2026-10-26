package leet.l_90;

import java.util.*;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    int MAX_SIZE = 21;
    int OFFSET = 10;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);

        result.add(new ArrayList<>());

        boolean[] visited = new boolean[MAX_SIZE];
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int offsetValue = value + OFFSET;
            if (visited[offsetValue]) continue;

            visited[offsetValue] = true;

            dfs(new ArrayList<>(), i);
        }

        return result;
    }

    private void dfs(List<Integer> list, int index) {
        if (index >= nums.length) return;

        int value = nums[index];
        list.add(value);
        result.add(new ArrayList<>(list));

        boolean[] visited = new boolean[MAX_SIZE];
        for (int i = index + 1; i < nums.length; i++) {
            int next = nums[i];
            int offsetNext = next + OFFSET;
            if (visited[offsetNext]) continue;

            visited[offsetNext] = true;

            dfs(list, i);
        }

        list.remove(list.size() - 1);
    }
}
