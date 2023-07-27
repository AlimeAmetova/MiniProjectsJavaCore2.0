package WorkWithStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class RemoveInStrings {
    public static void main(String[] args) {

        System.out.println(removeCharWord("Аа а А %% б 1 3 1", '%')); // Аа а А  б 1 3 1
        System.out.println(removeDuplicates("Аа а А %% б 1 3 1")); // Аа %б13
        System.out.println(removeDuplicates2("Аа а А %% б 1 3 1")); // Аа %б13


    }
    public static String removeCharWord(String str, char chars){
        StringBuilder builder = new StringBuilder();
        char[] ch = str.toCharArray();
        for (char removeChars : ch){
            if (removeChars != chars){
                builder.append(removeChars);
            }
        } return builder.toString().replaceAll("\\s+", " "); // чтобы убрать лишние пробелы
    }

    /*
Удаление повторяющихся символов
     */

    public static String removeDuplicates(String str){
        StringBuilder builder = new StringBuilder();
        char [] ch = str.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        for (char chars : ch){
            if (hashSet.add(chars)){
                builder.append(chars).append(" ");

            }
        } return builder.toString().replaceAll("\\s+", " ");
    }


    public static String removeDuplicates2(String str) {
        return Arrays.stream(str.split(""))
                .distinct() // distinct() возвращает новый поток различных элементов.
                // Поэтому его можно использовать для удаления дубликатов элементов из набора.
                .collect(Collectors.joining(" "))
                .replaceAll("\\s+", " ");
    }

}
