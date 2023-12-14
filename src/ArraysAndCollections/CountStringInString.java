package ArraysAndCollections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Подсчет числа появлений подстроки в строке
public class CountStringInString {
    public static void main(String[] args) {
        String str = "Hello hello hello world";
        String toFind = "hello";
        System.out.println(countString(str, toFind));

    }
    public static int countString(String string, String toFind) {
        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(string);
        int position = 0;
        int count = 0;
        while (matcher.find(position)) {
            position = matcher.start() + 1;
            count++;
        }
        return count;
    }
}
