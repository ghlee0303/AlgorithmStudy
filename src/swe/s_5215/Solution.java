package swe.s_5215;

import java.util.*;

public class Solution {
    static class Food {
        int index;
        int score;
        int value;

        Food(int index, int score, int value) {
            this.index = index;
            this.score = score;
            this.value = value;
        }
    }

    static List<Food> foodList = new ArrayList<>();
    static List<Food> resultList = new ArrayList<>();
    static int maxSize, maxValue;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            maxSize = sc.nextInt();
            maxValue = sc.nextInt();

            for (int i = 0; i < maxSize; i++) {
                int score = sc.nextInt();
                int cal = sc.nextInt();

                foodList.add(new Food(i, score, cal));
            }

            int value = dfs(0);

            System.out.println("#" + tc + " " + value);
        }
    }

    private static int dfs(int index) {
        int sumValue = sumValue();
        int sumScore = sumScore();

        if (index >= maxSize || index < 0) return sumScore;
        if (sumValue > maxValue) return sumScore - resultList.remove(index - 1).score;

        int maxValue = 0;
        for (Food food : foodList) {
            if (contains(food)) continue;

            resultList.add(food);
            maxValue = Math.max(maxValue, dfs(index + 1));
            resultList.remove(food);
        }

        return maxValue;
    }

    private static int sumValue() {
        int sum = 0;
        for (Food food : resultList) {
            sum += food.value;
        }

        return sum;
    }

    private static int sumScore() {
        int sum = 0;
        for (Food food : resultList) {
            sum += food.score;
        }

        return sum;
    }

    private static boolean contains(Food other) {
        for (Food food : resultList) {
            if (food.equals(other)) return true;
        }

        return false;
    }
}
