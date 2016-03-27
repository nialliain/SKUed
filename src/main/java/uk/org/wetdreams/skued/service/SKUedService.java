package uk.org.wetdreams.skued.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.aggregator.OrderAggregator;
import uk.org.wetdreams.skued.service.aggregator.RegionAggregator;
import uk.org.wetdreams.skued.service.dao.market.MarketRequirementDao;
import uk.org.wetdreams.skued.service.dao.order.OrderDao;
import uk.org.wetdreams.skued.service.domain.MarketReqirement;
import uk.org.wetdreams.skued.service.domain.Order;
import uk.org.wetdreams.skued.service.domain.PurchaseOrder;
import uk.org.wetdreams.skued.service.domain.RegionalMarketRequirement;

import java.util.Collection;
import java.util.Map;

@Component
public class SKUedService {

    @Autowired
    private MarketRequirementDao marketRequirementDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderAggregator orderAggregator;

    @Autowired
    private RegionAggregator regionAggregator;

    public Collection<RegionalMarketRequirement> getAllMarketRequirements(){
        return regionAggregator.aggregateMarketRequirements(marketRequirementDao.getMarketRequirements());
    }

    public Collection<Order> getAllOrders(){
        return orderDao.getOrders();
    }

    public Collection<PurchaseOrder> generatePurchaseOrders(){
        return orderAggregator.aggregateOrders(orderDao.getOrders());
    }

    public void upsertOrder(Order order) {
        orderDao.upsertOrder(order);
    }

    public void deleteOrder(Order order) {
        orderDao.deleteOrder(order);
    }

    public void upsertMarketRequirement(MarketReqirement marketReqirement) {
        marketRequirementDao.upsertMarketRequirement(marketReqirement);
    }
}
