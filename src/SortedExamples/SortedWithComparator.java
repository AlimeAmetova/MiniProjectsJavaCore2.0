package SortedExamples;

import java.util.Arrays;
import java.util.Comparator;

public class SortedWithComparator {
    public static void main(String[] args) {
        sortComparator();

    }
    public static void sortComparator(){
        String str = "Тут вводим предложение, которое необходимо отсортировать ";

        // Разбиваем строку на слова, используя пробел в качестве разделителя
        String[] words = str.split("\\s");

        // Сортируем слова по их длине, а затем по алфавиту
        Arrays.stream(words)
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .forEach(s -> System.out.printf("%s ", s));
    }
}

