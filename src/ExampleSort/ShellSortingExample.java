package ExampleSort;

import java.util.Arrays;

public class ShellSortingExample {
    public static void main(String[] args) {
        int[] arr = {1, 6, 8, -6, 89, 777, 6, 21};
        sortBySell(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortBySell(int[] array) {
        int step = array.length / 2;
        while (step > 0) {
            for (int i = 0; i < array.length - step; i++) {
                int j = i;
                while (j >= 0 && array[j] > array[j + step]) {
                    int temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;
        }
    }
}

