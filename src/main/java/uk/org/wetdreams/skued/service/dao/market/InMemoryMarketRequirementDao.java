package uk.org.wetdreams.skued.service.dao.market;

import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.domain.MarketReqirement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryMarketRequirementDao implements MarketRequirementDao {

    private Map<String, MarketReqirement> marketReqirements = new HashMap<>();

    InMemoryMarketRequirementDao(){
        marketReqirements.put("Spain", new MarketReqirement("Spain", "GenericEurope"));
        marketReqirements.put("SpainMarket", new MarketReqirement("SpainMarket", "GenericEurope"));
        marketReqirements.put("Germany", new MarketReqirement("Germany", "Generic"));
        marketReqirements.put("France", new MarketReqirement("France", "France"));
        marketReqirements.put("Brazil", new MarketReqirement("Brazil", "Generic"));
        marketReqirements.put("Argentina", new MarketReqirement("Argentina", "Generic"));
    }

    @Override
    public Collection<MarketReqirement> getMarketRequirements() {
        return marketReqirements.values();
    }

    @Override
    public MarketReqirement getMarketRequirement(String market) {
        return marketReqirements.get(market);
    }
}
