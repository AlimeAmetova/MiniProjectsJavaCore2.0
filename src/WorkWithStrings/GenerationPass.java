package WorkWithStrings;

import java.security.SecureRandom;

public class GenerationPass {

    public static void main(String[] args) {
        System.out.println(passwordGeneration(8));
    }

    public static String passwordGeneration(int countChar) {
        if (countChar < 4) {
            throw new IllegalArgumentException("Количество символов должно быть больше 4");
        }

        StringBuilder builder = new StringBuilder();
        SecureRandom random = new SecureRandom();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@+";

        for (int i = 0; i < countChar; i++) {
            int randomIndex = random.nextInt(chars.length());
            builder.append(chars.charAt(randomIndex));
        }

        return builder.toString();
    }
}


