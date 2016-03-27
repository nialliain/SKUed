package uk.org.wetdreams.skued.service.dao.order;

import uk.org.wetdreams.skued.service.domain.Order;

import java.util.Collection;

public interface OrderDao {

    Collection<Order> getOrders();

    void addOrder(Order order);

    void deleteOrder(Order order);
}
