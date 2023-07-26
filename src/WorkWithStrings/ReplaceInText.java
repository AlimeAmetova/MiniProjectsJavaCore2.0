package WorkWithStrings;

public class ReplaceInText {
    public static String txt = "Это предлООжение необходимо изменить";

    public static void main(String[] args) {
        System.out.println(replaceWordInText(txt, "предлООжение"));

    }


    public static String replaceWordInText(String txt, String word) {
        String[] splitWord = txt.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (String s : splitWord) {
            if (s.equals(word)) {
                String newTxt = s.replaceAll(word, "замененное_слово");
                builder.append(newTxt).append(" ");
            } else {
                builder.append(s).append(" ");
            }
        }
        return builder.toString().trim();
    }


}