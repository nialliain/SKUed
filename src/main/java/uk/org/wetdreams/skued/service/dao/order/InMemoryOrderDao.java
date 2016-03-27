package uk.org.wetdreams.skued.service.dao.order;

import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.dao.market.MarketRequirementDao;
import uk.org.wetdreams.skued.service.domain.MarketReqirement;
import uk.org.wetdreams.skued.service.domain.Order;

import java.util.*;

@Component
public class InMemoryOrderDao implements OrderDao {

    private Map<String,Order> orders = new HashMap<>();

    InMemoryOrderDao(){
        addOrder(new Order("Spain", 100));
        addOrder(new Order("Germany", 20));
        addOrder(new Order("France", 10));
        addOrder(new Order("Brazil", 100));
        addOrder(new Order("Argentina", 10000));
    }

    @Override
    public Collection<Order> getOrders() {
        return orders.values();
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.getMarket(), order);
    }

    @Override
    public void deleteOrder(Order order) {
        orders.remove(order.getMarket());
    }
}
