package GenerArrayFindMinMax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindArraysMinMax {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 0;
            do {
                System.out.println("Введите натуральное число для определения длины массива");
                try {
                    String input = reader.readLine();
                    if (input.isEmpty()) {
                        continue;  // Пропускаем пустой ввод и повторяем цикл
                    }
                    n = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный формат числа. Попробуйте снова.");
                }
            } while (!Library.checkNotNull(n));

            final int MIN = 0;
            final int MAX = 200;

            int[] array = Library.generationArray(MIN, MAX, n);
            Library.findIndex(array);
            System.out.println(Arrays.toString(array));
            System.out.format(
                    "Индекс максимального значения массива: %d%n" +
                            "Индекс минимального значения: %d%n" +
                            "Mинимальное число: %d%n" +
                            "Максимальное число: %d%n",
                    Library.getIndexOfMax(),
                    Library.getIndexOfMin(),
                    Library.findMinVal(array),
                    Library.findMaxVal(array));
        }
    }

    static class Library {
        private static int indexOfMin;
        private static int indexOfMax;

        // Проверка на натуральное число
        static boolean checkNotNull(int n) {
            if (n <= 1) {
                System.out.println("Число должно быть больше 1\n");
                return false;
            }
            return true;
        }

        // Генерация массива случайных чисел
        public static int[] generationArray(final int MIN, final int MAX, int n) {
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) ((Math.random() * (MAX - MIN)) + MIN);
            }
            return array;
        }

        // Поиск минимального значения в массиве
        static int findMinVal(int[] array) {
            return Arrays.stream(array).min().orElse(-1);
        }

        // Поиск максимального значения в массиве
        static int findMaxVal(int[] array) {
            return Arrays.stream(array).max().orElse(-1);
        }

        // Поиск индексов минимального и максимального значений в массиве
        public static void findIndex(int[] array) {
            indexOfMin = 0;
            indexOfMax = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < array[indexOfMin]) {
                    indexOfMin = i;
                }
                if (array[i] > array[indexOfMax]) {
                    indexOfMax = i;
                }
            }
        }

        // Получение индекса максимального значения
        public static int getIndexOfMax() {
            return indexOfMax;
        }

        // Получение индекса минимального значения
        public static int getIndexOfMin() {
            return indexOfMin;
        }
    }
}