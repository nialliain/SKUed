package uk.org.wetdreams.skued.service.dao.order;

import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.domain.Order;

import java.util.*;

@Component
public class InMemoryOrderDao implements OrderDao {

    private Map<String,Order> orders = new HashMap<>();

    InMemoryOrderDao(){
        upsertOrder(new Order("Spain-Domestic", 20000));
        upsertOrder(new Order("Germany-Domestic", 21000));
        upsertOrder(new Order("France-Domestic", 10000));
        upsertOrder(new Order("Brazil-Domestic", 500));
        upsertOrder(new Order("Argentina-Domestic", 10000));
        upsertOrder(new Order("Spain-Travel", 24500));
        upsertOrder(new Order("Germany-Travel", 200));
        upsertOrder(new Order("France-Travel", 1000));
    }

    @Override
    public Collection<Order> getOrders() {
        return orders.values();
    }

    @Override
    public void upsertOrder(Order order) {
        orders.put(order.getMarket(), order);
    }

    @Override
    public void deleteOrder(Order order) {
        orders.remove(order.getMarket());
    }
}
