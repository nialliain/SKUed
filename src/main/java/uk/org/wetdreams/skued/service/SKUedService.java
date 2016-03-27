package uk.org.wetdreams.skued.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.aggregator.OrderMatcher;
import uk.org.wetdreams.skued.service.dao.market.MarketRequirementDao;
import uk.org.wetdreams.skued.service.dao.order.OrderDao;
import uk.org.wetdreams.skued.service.domain.MarketReqirement;
import uk.org.wetdreams.skued.service.domain.Order;
import uk.org.wetdreams.skued.service.domain.PurchaseOrder;

import java.util.Collection;

@Component
public class SKUedService {

    @Autowired
    private MarketRequirementDao marketRequirementDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderMatcher orderMatcher;

    public Collection<MarketReqirement> getAllMarketRequirements(){
        return marketRequirementDao.getMarketRequirements();
    }

    public Collection<Order> getAllOrders(){
        return orderDao.getOrders();
    }

    public Collection<PurchaseOrder> generatePurchaseOrders(){
        return orderMatcher.aggregateOrders(orderDao.getOrders());
    }

    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    public void deleteOrder(Order order) {
        orderDao.deleteOrder(order);
    }
}
