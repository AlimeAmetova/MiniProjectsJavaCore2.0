package ExampleSort;

import java.util.Arrays;

public class SortBySelectExample {
    public static void main(String[] args) {
        int [] arr = {1, 6, 8, -6, 89, 777, 6, 21};
        sortBySelect(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortBySelect(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
