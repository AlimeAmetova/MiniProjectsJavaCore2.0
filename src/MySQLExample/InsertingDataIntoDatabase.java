package MySQLExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertingDataIntoDatabase {
    public static void main(String[] args) {
        // Параметры подключения к базе данных MySQL
        String url = "jdbc:mysql://xxxxxxxxxxxxx/xxxxxxxxxxxx"; // указываем свои данные
        String username = "xxx";
        String password = "xxxxxxxxxxxxx";

        try {
            // Установка соединения с базой данных
            Connection connection = DriverManager.getConnection(url, username, password);

            // Создание списка имен
            List<String> names = new ArrayList<>();
            names.add("John");
            names.add("Alice");
            names.add("Bob");
            names.add("Emma");
            names.add("Michael");
            names.add("Olivia");
            names.add("David");
            names.add("Sophia");
            names.add("Daniel");
            names.add("Emily");

            // Заполнение списка датами рождения
            List<String> birthdates = new ArrayList<>();
            birthdates.add("1990-01-01");
            birthdates.add("1985-03-15");
            birthdates.add("1992-06-30");
            birthdates.add("1998-09-10");
            birthdates.add("1994-12-25");
            birthdates.add("1991-04-05");
            birthdates.add("1988-07-20");
            birthdates.add("1996-10-12");
            birthdates.add("1993-02-18");
            birthdates.add("1987-05-08");

            // Добавление номеров телефонов
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add("1234567890");
            phoneNumbers.add("9876543210");
            phoneNumbers.add("5555555555");
            phoneNumbers.add("9999999999");
            phoneNumbers.add("1111111111");
            phoneNumbers.add("7777777777");
            phoneNumbers.add("4444444444");
            phoneNumbers.add("8888888888");
            phoneNumbers.add("2222222222");
            phoneNumbers.add("6666666666");

            // Добавление статуса
            List<String> statuses = new ArrayList<>();
            statuses.add("VIP");
            statuses.add("Simple");
            statuses.add("Simple");
            statuses.add("VIP");
            statuses.add("Simple");
            statuses.add("VIP");
            statuses.add("Simple");
            statuses.add("Simple");
            statuses.add("VIP");
            statuses.add("Simple");

            // Вставка данных в базу данных
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                String birthdate = birthdates.get(i);
                String phoneNumber = phoneNumbers.get(i);
                String status = statuses.get(i);

                String query = "INSERT INTO users (name, birthdate, phone_number, status) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, name);
                statement.setString(2, birthdate);
                statement.setString(3, phoneNumber);
                statement.setString(4, status);
                statement.executeUpdate();
            }

            System.out.println("Данные успешно добавлены в базу данных.");

            // Закрытие соединения с базой данных
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}