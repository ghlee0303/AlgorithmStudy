package leet.l_40;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        Solution solution = new Solution();

        List<List<Integer>> result = solution.combinationSum2(nums, target);

        System.out.println(result);
    }

}
