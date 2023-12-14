package ArraysAndCollections;

import java.util.HashMap;
import java.util.Map;

public class CharacterCountExample {
    public static void main(String[] args) {
        String str = "Hello world!";
        System.out.println(charCount(str)); // { пробел=1, !=1, r=1, d=1, e=1, w=1, H=1, l=3, o=2}

    }

    public static Map<Character, Integer> charCountInStr(String str){
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
              charCountMap.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return charCountMap;
        }

    public static Map<Character, Integer> charCount(String str){
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : str.toCharArray()){
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        } return charCountMap;
    }


    }

