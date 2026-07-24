package progs.p_42888;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] list = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(list)));
    }
}
