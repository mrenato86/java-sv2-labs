package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = new ArrayList<>(orders);
    }

    public void addCoffeeOrder(CoffeeOrder coffeeOrder) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(coffeeOrder);
    }

    public Integer getTotalIncome() {
        return orders.stream()
                .flatMap(cl -> cl.getCoffeeList().stream())
                .reduce(0, (s, c) -> s + c.getPrice(), Integer::sum);
    }

    public Integer getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(co -> co.getDateTime().toLocalDate().equals(date))
                .flatMap(cl -> cl.getCoffeeList().stream())
                .reduce(0, (s, c) -> s + c.getPrice(), Integer::sum);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(cl -> cl.getCoffeeList().stream())
                .filter(cl -> cl.getType() == type)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return orders.stream()
                .filter(co -> co.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(co -> co.getDateTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());
    }
}
