package leet.l_40;

import java.util.*;

public class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> result = new ArrayList<>();
    int MAX_SIZE = 51;

    public List<List<Integer>> combinationSum2(int[] c, int t) {
        candidates = Arrays.stream(c).sorted().toArray();
        target = t;

        boolean[] visited = new boolean[MAX_SIZE];

        for (int i = 0; i < candidates.length; i++) {
            int value = candidates[i];
            if (visited[value]) continue;
            if (value > target) break;

            visited[value] = true;

            dfs(new ArrayList<>(), i, 0);
        }

        return result;
    }

    public void dfs(List<Integer> list, int index, int sum) {
        int value = candidates[index];
        sum += value;
        if (sum > target) return;

        list.add(value);
        if (sum == target) {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);

            return;
        }

        boolean[] visited = new boolean[MAX_SIZE];
        for (int i = index + 1; i < candidates.length; i++) {
            int next = candidates[i];
            if (sum + next > target) break;
            if (visited[next]) continue;

            visited[next] = true;
            dfs(list, i, sum);
        }

        list.remove(list.size() - 1);
    }
}
