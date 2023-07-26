package ReadFileAndConverting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderConvertingStrings {
    public static void main(String[] args) throws IOException {
        // Путь к файлу
        String path = "Путь к файлу.txt";
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Преобразование строки в число с удалением лишних пробелов
                int number = Integer.parseInt(line.trim());

                numbers.add(number);
            }
            List<Integer> evenNumbers = numbers.stream()
                    .filter(x -> x % 2 == 0) //  только четные числа
                    .sorted()
                    .toList();

            System.out.println(evenNumbers);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число: " + e.getMessage());
        }
    }
}