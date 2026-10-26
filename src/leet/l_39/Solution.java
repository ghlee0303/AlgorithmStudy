package leet.l_39;

import java.util.*;

public class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;

        for (int i = 0; i < candidates.length; i++) {
            dfs(new ArrayList<>(), i, 0);
        }

        return result;
    }

    private void dfs(List<Integer> list, int index, int sum) {
        int value = candidates[index];
        sum += value;
        if (sum > target) return;

        list.add(value);
        if (sum == target) {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);

            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int next = candidates[i];
            if (sum + next > target) break;

            dfs(list, i, sum);
        }

        list.remove(list.size() - 1);
    }
}
