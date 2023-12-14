package ExampleSort;

import java.util.Arrays;

public class BubbleSortExample {

    public static void main(String[] args) {
        int [] arr = {1, 6, 8, -6, 89, 777, 6, 21};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){

        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j +1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
