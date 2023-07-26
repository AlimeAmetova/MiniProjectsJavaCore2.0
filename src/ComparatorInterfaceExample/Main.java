package ComparatorInterfaceExample;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(11, 235));
        orders.add(new Order(9, 90));
        orders.add(new Order(10, 360));
        orders.add(new Order(12, 500));


        orders.sort(OrderComparatorFunctional.AMOUNT.getComparator());  // Сортировка списка orders по сумме

        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
