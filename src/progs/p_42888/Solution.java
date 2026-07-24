package progs.p_42888;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42888">
 * 프로그래머스 오픈채팅방
 * </a>
 *
 * 2026 07 24
 */
public class Solution {
    final String ENTER = "Enter";
    final String LEAVE = "Leave";

    Map<String, String> userMap = new HashMap<>();

    public String[] solution(String[] record) {
        createUserMap(record);

        List<String> result = new ArrayList<>();
        for (String str : record) {
            String[] parts = str.split(" ");
            String type = parts[0];
            String id = parts[1];
            String name = userMap.get(id);

            switch (type) {
                case ENTER: {
                    result.add(name + "님이 들어왔습니다.");
                    break;
                }
                case LEAVE: {
                    result.add(name + "님이 나갔습니다.");
                }
            }
        }

        return result.toArray(String[]::new);
    }

    private void createUserMap(String[] record) {
        for (String str : record) {
            String[] parts = str.split(" ");
            String type = parts[0];

            if (type.equals(LEAVE)) continue;

            String id = parts[1];
            String name = parts[2];

            userMap.put(id, name);
        }
    }
}
