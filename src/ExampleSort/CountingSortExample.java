package ExampleSort;

import java.util.Arrays;

public class CountingSortExample {
    public static void main(String[] args) {
        int [] arr = {1, 6, 8, -6, 89, 777, 6, 21};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void countingSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i] - min]++;
        }
        int sortedindex = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr[sortedindex++] = i + min;
                counts[i]--;
            }
        }
    }
}
