package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) throws IOException {
        int length = 20;
        Integer[] inputs = new Integer[length];
        for (int i = 0; i < length; i++) {
            inputs[i] = (int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(inputs));
        System.out.println(Arrays.toString(sort(inputs)));
        Arrays.sort(inputs);
        System.out.println(Arrays.toString(inputs));
    }

    public static Integer[] sort(Integer[] numbers) {
        int length = numbers.length;
        if (length == 1) {
            return numbers;
        }
        int halfIndex = length / 2;
        int secondIndex = length - halfIndex;
        Integer[] first = new Integer[halfIndex];
        Integer[] second = new Integer[secondIndex];

        for (int i = 0; i < halfIndex; i++) {
            first[i] = numbers[i];
        }
        for (int i = 0; i < secondIndex; i++) {
            second[i] = numbers[length-secondIndex+i];
        }

        Integer[] num1 = sort(first);
        Integer[] num2 = sort(second);

        return merge(num1, num2);
    }

    public static Integer[] merge(Integer[] num1, Integer[] num2) {
        int n1 = num1.length;
        int k1 = 0;
        int n2 = num2.length;
        int k2 = 0;
        int k = n1 + n2;
        Integer[] result = new Integer[k];

        int i = 0;
        while (k1 < n1 && k2 < n2) {
            if (num1[k1] < num2[k2]) {
                result[i] = num1[k1];
                k1++;
            } else {
                result[i] = num2[k2];
                k2++;
            }
            i++;
        }

        for (int j = i; j < k; j++) {
            if (k1 < n1) {
                result[j] = num1[k1];
                k1++;
            } else if (k2 < n2) {
                result[j] = num2[k2];
                k2++;
            }
        }

        return result;
    }
}
