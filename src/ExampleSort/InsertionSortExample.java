package ExampleSort;

import java.util.Arrays;

public class InsertionSortExample {

    public static void main(String[] args) {
        int[] arr = {1, 6, 8, -6, 89, 777, 6, 21};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) { // i - разделяющий маркер
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) { // пока не будет найден меньший элемент
                array[j] = array[j - 1]; // сдвигаем элементы вправо
                --j;
            }
            array[j] = temp;
        }
    }
}
