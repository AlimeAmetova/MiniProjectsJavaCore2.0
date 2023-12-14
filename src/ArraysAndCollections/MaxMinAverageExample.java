package ArraysAndCollections;

import java.util.Arrays;
import java.util.Comparator;

public class MaxMinAverageExample {
    public static void main(String[] args) {
        //1.
        int[] numbers = {5, 2, 9, 1, 7};

        int min = Arrays.stream(numbers).min().getAsInt();
        int max = Arrays.stream(numbers).max().getAsInt();
        double average = Arrays.stream(numbers).average().getAsDouble();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Average: " + average);

        //2.
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        String min2 = Arrays.stream(names).min(Comparator.naturalOrder()).get();
        String max2 = Arrays.stream(names).max(Comparator.naturalOrder()).get();
        double averageLength = Arrays.stream(names).mapToInt(String::length).average().getAsDouble();

        System.out.println("Min: " + min2);
        System.out.println("Max: " + max2);
        System.out.println("Average length: " + averageLength);
        
        //3.

        Person[] people = {
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 20),
                new Person("David", 35),
                new Person("Eve", 28)
        };

        int minAge = Arrays.stream(people).mapToInt(Person::getAge).min().getAsInt();
        int maxAge = Arrays.stream(people).mapToInt(Person::getAge).max().getAsInt();
        double averageAge = Arrays.stream(people).mapToInt(Person::getAge).average().getAsDouble();

        System.out.println("Min age: " + minAge);
        System.out.println("Max age: " + maxAge);
        System.out.println("Average age: " + averageAge);
    }


    private static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }
}
