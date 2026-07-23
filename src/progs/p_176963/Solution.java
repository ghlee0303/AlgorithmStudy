package progs.p_176963;

import java.util.HashMap;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/176963">
 * 프로그래머스 추억 점수
 * </a>
 *
 * 날짜 미상
 */

public class Solution {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> personGrade = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            personGrade.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int grade = 0;
            for (String p : photo[i]) {
                grade += personGrade.get(p) != null ? personGrade.get(p) : 0;
            }
            answer[i] = grade;
        }

        return answer;
    }
}
