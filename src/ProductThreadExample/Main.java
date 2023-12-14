package ProductThreadExample;

import java.util.ArrayList;
import java.util.List;
/*Этот код демонстрирует примитивную симуляцию работы
магазина с использованием многопоточности. Поток магазина продает товары, а потоки клиентов покупают их.*/


public class Main {

    public static ProductController productController = new ProductController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {

        Thread shop = new Thread(new ShopProduct(), "Магазин");
        Thread customer1 = new Thread(new Person(), "Клиент 1");
        Thread customer2 = new Thread(new Person(), "Клиент 2");

        shop.start();
        customer1.start();
        customer2.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class ShopProduct implements Runnable {
        @Override
        public void run() {

            while (!isStopped) {
                productController.sell(getRandomProduct(), getRandomCount());
                waitAMoment();
                waitAMoment();
                waitAMoment();
            }
        }
    }

    public static class Person implements Runnable {

        @Override
        public void run() {
            while (!isStopped) {
                productController.buy(getRandomProduct(), getRandomCount());
                waitAMoment();
            }
        }
    }

    public static int getRandomCount() {  // Генерация случайного количества товара
        return (int) (Math.random() * 3) + 1;
    }

    public static Product getRandomProduct() { // Получение случайного товара из списка доступных товаров
        int index = (int) (Math.random() *  ProductController.allProducts.size());
        List<Product> products = new ArrayList<>(ProductController.allProducts.keySet()); // передаем в список keySet() Product ключи
        return products.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }
}