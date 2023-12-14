package ArraysAndCollections;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingChars {
/*    Коллекция LinkedHashMap заполняется символами в качестве ключей и
    числом появлений в качестве значений. После того как коллекция LinkedHashMap будет
    заполнена, будет возвращен первый ключ, значение которого равно 1. */

    public static void main(String[] args) {
        String str = "Hello world!";
        System.out.println(firstNonRepeatedChar(str));

    }

    public static char firstNonRepeatedChar(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>() ;
        for (int i = 0; i < str.length (); i++) {
            char ch = str.charAt(i);
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        for (Map.Entry<Character, Integer> entry: chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }
}
