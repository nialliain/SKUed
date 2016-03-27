package uk.org.wetdreams.skued.service.aggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.dao.market.MarketRequirementDao;
import uk.org.wetdreams.skued.service.domain.MarketReqirement;
import uk.org.wetdreams.skued.service.domain.Order;
import uk.org.wetdreams.skued.service.domain.PurchaseOrder;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderAggregator {

    private static final String UNKNOWN_SKU = "No known SKU";

    @Autowired
    private MarketRequirementDao requirementDao;

    public Collection<PurchaseOrder> aggregateOrders(Collection<Order> orders){
        Map<String,PurchaseOrder> pos = new HashMap<>();
        for(Order ord : orders){
            MarketReqirement req = requirementDao.getMarketRequirement(ord.getMarket());
            String skuType = req == null ? UNKNOWN_SKU : req.getSkuType();
            if(!pos.containsKey(skuType)){
                pos.put(skuType,new PurchaseOrder(skuType,ord.getQty(),ord.getMarket()));
            } else {
                pos.get(skuType).incrementOrder(ord.getQty(),ord.getMarket());
            }
        }
        return pos.values();
    }

}
