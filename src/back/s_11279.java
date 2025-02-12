package back;

import java.lang.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The main method must be in a class named "Main".
public class s_11279 {
    static Integer[] heapArray;
    static int heapSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputSize = Integer.parseInt(br.readLine());
        int maxHeapSize = 0;
        Integer[] inputArray = new Integer[inputSize];

        for (int i = 0; i < inputSize; i++) {
            int inputValue = Integer.parseInt(br.readLine());
            inputArray[i] = inputValue;

            if (inputValue != 0) {
                maxHeapSize++;
            }
        }

        heapArray = new Integer[maxHeapSize];
        for (int i = 0; i < inputSize; i++) {
            int inputValue = inputArray[i];

            if (inputValue != 0) {
                add(inputValue);
            } else if (heapSize == 0) {
                bw.write(0 + "\n");
            } else {
                bw.write(remove() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void add(int addValue) {
        heapArray[heapSize++] = addValue;

        if (heapSize <= 1) {
            return;
        }

        int targetIndex = heapSize - 1;
        while (targetIndex > 0) {
            int parentIndex = (targetIndex - 1) / 2;

            int parentValue = heapArray[parentIndex];
            int targetValue = heapArray[targetIndex];

            if (parentValue > targetValue) {
                break;
            }

            swap(heapArray, parentIndex, targetIndex);
            targetIndex = parentIndex;
        }
    }

    public static int remove() {
        int result = heapArray[0];

        if (heapSize == 0) {
            return 0;
        } else if (heapSize == 1) {
            heapArray[0] = null;
            heapSize = 0;

            return result;
        }

        int resultSize = heapSize - 1;
        heapArray[0] = heapArray[resultSize];
        heapArray[resultSize] = null;

        int targetIndex = 0;
        while (true) {
            int leftChildIndex = targetIndex * 2 + 1;
            int rightChildIndex = targetIndex * 2 + 2;

            if (leftChildIndex >= resultSize) {
                break;
            }

            int highestIndex;
            if (rightChildIndex >= resultSize) {
                highestIndex = leftChildIndex;
            } else {
                highestIndex = (heapArray[leftChildIndex] > heapArray[rightChildIndex]) ? leftChildIndex : rightChildIndex;
            }

            if (heapArray[targetIndex] >= heapArray[highestIndex]) {
                break;
            }

            swap(heapArray, targetIndex, highestIndex);

            targetIndex = highestIndex;
        }

        heapSize = resultSize;

        return result;
    }

    public static void swap(Integer[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}