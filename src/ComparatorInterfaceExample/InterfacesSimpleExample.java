package ComparatorInterfaceExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Supplier;


public class InterfacesSimpleExample {
    public static void main(String[] args) {
        //  randomSupplier(int insertNumbersEnd)
        int random = randomSupplier(100);
        System.out.println(random);
        //  sortComparator()
        sortComparator();

    }


    public static int randomSupplier(int insertNumbersEnd) {

        Supplier<Integer> integerSupplier = () -> new Random().nextInt(insertNumbersEnd);
        if (insertNumbersEnd <= 0) {
            throw new IllegalArgumentException("insertNumbersEnd должен быть положительным числом");
        }
        return integerSupplier.get(); // Вывод: случайное число от 0 до 99
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



