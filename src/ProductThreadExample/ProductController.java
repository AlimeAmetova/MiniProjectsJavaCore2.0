package ProductThreadExample;

import java.util.HashMap;

public class ProductController {

    public static HashMap<Product, Integer> allProducts = new HashMap<>();

    static {
        Product milk = new Product();
        milk.setName("Молоко Вкуснотеево");
        allProducts.put(milk, 5);

        Product tea = new Product();
        tea.setName("Чай в пакетиках");
        allProducts.put(tea, 10);

        Product coffee = new Product();
        coffee.setName("Кофе Lavazza");
        allProducts.put(coffee, 5);

    }

    public synchronized void buy(Product product, int count) {
        if (!allProducts.containsKey(product)) {
            System.out.println("Этого продукта нет в наличии\n");
        }
        Integer currentCount = allProducts.get(product); // Общее число продукта в наличии
        if (currentCount < count) {
            System.out.printf("%s хочет купить %s %d шт. В наличии - %d. Покупка отклонена\n",
                    Thread.currentThread().getName(), product.getName(), count, currentCount);
        } else {
            int res = currentCount - count;
            allProducts.put(product, (res)); // Добавляем в лист покупок
            System.out.printf("%s купил(а) %s %d шт. Осталось - %d\n", Thread.currentThread().getName(),
                    product.getName(), count, res);
        }
    }

    public synchronized void sell(Product product, int count) {
        System.out.println(Thread.currentThread().getName() + " Закупка товара: " + product.getName() + " " + count + " шт.");
        Integer currentCount = allProducts.get(product);
        allProducts.put(product, (currentCount + count));
    }

}



