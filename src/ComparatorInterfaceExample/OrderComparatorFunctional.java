package ComparatorInterfaceExample;

import java.util.Comparator;

public enum OrderComparatorFunctional {
    ID(Comparator.comparingInt(Order::getOrderId)),
    AMOUNT(Comparator.comparingDouble(Order::getAmount));

    private Comparator<Order> comparator;

    OrderComparatorFunctional(Comparator<Order> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Order> getComparator() {
        return comparator;
    }
}
