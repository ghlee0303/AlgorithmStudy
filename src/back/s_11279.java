package back;

import java.lang.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The main method must be in a class named "Main".
public class s_11279 {
    static Integer[] heapArray = new Integer[0];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            Integer inputValue = Integer.parseInt(br.readLine());

            if (inputValue != 0) {
                add(inputValue);
            } else if (heapArray.length == 0) {
                bw.write(0 + "\n");
            } else {
                bw.write(remove() + "\n");
            }

            System.out.println(inputValue + ": "+ Arrays.toString(heapArray));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void add(int addValue) {
        int size = heapArray.length;
        Integer[] resultArray = Arrays.copyOf(heapArray, size + 1);
        resultArray[size++] = addValue;

        if (size <= 1) {
            heapArray = resultArray;
            return;
        }

        int targetIndex = size - 1;
        while (targetIndex > 0) {
            int parentIndex = (targetIndex - 1) / 2;

            int parentValue = resultArray[parentIndex];
            int targetValue = resultArray[targetIndex];

            if (parentValue > targetValue) {
                break;
            }

            swap(resultArray, parentIndex, targetIndex);
            targetIndex = parentIndex;
        }

        heapArray = resultArray;
    }

    public static int remove() {
        int size = heapArray.length;

        if (size == 0) {
            return 0;
        } else if (size == 1) {
            int result = heapArray[0];
            heapArray = new Integer[0];

            return result;
        }

        int result = heapArray[0];
        Integer[] resultArray = shiftArray(heapArray);

        // 자식이 있는지 검증 후 있다면 더 큰 값과 바꿈
        int targetIndex = 0;
        int resultSize = resultArray.length;
        while (true) {
            int leftChildIndex = targetIndex * 2 + 1;
            int rightChildIndex = targetIndex * 2 + 2;;

            if (leftChildIndex >= resultSize) {
                break;
            }

            int highestIndex;
            if (rightChildIndex >= resultSize) {
                highestIndex = leftChildIndex;
            } else {
                highestIndex = (resultArray[leftChildIndex] > resultArray[rightChildIndex]) ? leftChildIndex : rightChildIndex;
            }

            if (resultArray[targetIndex] >= resultArray[highestIndex]) {
                break;
            }

            swap(resultArray, targetIndex, highestIndex);

            targetIndex = highestIndex;
        }

        return result;
    }

    public static Integer[] shiftArray(Integer[] arr) {
        int newSize = arr.length - 1;
        Integer[] newArr = new Integer[newSize];
        newArr[0] = arr[newSize]; // 마지막 값을 첫 번째로 이동

        if (newSize == 1) {
            return newArr;
        }

        System.arraycopy(arr, 1, newArr, 1, newSize - 1);

        return newArr;
    }

    public static void swap(Integer[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}