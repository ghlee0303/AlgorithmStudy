package leet.l_39;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;

        Solution solution = new Solution();

        List<List<Integer>> result = solution.combinationSum(nums, target);

        System.out.println(result);
    }

}
