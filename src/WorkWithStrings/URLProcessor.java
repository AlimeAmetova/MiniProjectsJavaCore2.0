package WorkWithStrings;

import java.util.regex.Pattern;

public class URLProcessor {
    /**
     * Извлекает параметры запроса из URL и выводит их на экран.
     */
    public static void extractParametersUrl() {
        String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";

        // Разделяем URL на две части: до "?" и после "?"
        String[] parts = url.split("\\?");
        if (parts.length > 1) {
            // Разделяем параметры запроса по символу "&"
            String[] parameters = parts[1].split("&");
            for (String parameter : parameters) {
                // Разделяем каждый параметр на ключ и значение по символу "="
                String[] keyValue = parameter.split("=");

                // Выводим ключ параметра
                System.out.println(keyValue[0]);
            }
        }
    }

    /**
     * Извлекает параметры запроса из URL, удаляет цифры и знаки препинания,
     * и заменяет значение "Amigo" на пустую строку, затем выводит результат на экран.
     */
    public static void extractParametersUrl2() {
        String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";

        // Разделяем URL на две части: до "?" и после "?"
        String[] parts = url.split("\\?");
        if (parts.length > 1) {
            // Разделяем параметры запроса по символу "&"
            String[] parameters = parts[1].split("&");
            for (String parameter : parameters) {
                // Удаляем цифры и знаки препинания из параметра
                Pattern pattern = Pattern.compile("[\\d\\p{Punct}]");
                String result = pattern.matcher(parameter).replaceAll("");

                // Заменяем значение "Amigo" на пустую строку
                result = result.replace("Amigo", "");

                // Выводим результат
                System.out.println(result);
            }
        }
    }

    public static void main(String[] args) {
        // Извлекаем параметры запроса из URL
        extractParametersUrl();
        extractParametersUrl2();
    }
}
