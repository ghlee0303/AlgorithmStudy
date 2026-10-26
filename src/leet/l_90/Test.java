package leet.l_90;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};

        Solution solution = new Solution();

        List<List<Integer>> result = solution.subsetsWithDup(nums);

        System.out.println(result);
    }

}
