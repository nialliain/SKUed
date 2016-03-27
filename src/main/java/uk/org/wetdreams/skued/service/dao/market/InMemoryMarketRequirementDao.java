package uk.org.wetdreams.skued.service.dao.market;

import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.domain.MarketReqirement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryMarketRequirementDao implements MarketRequirementDao {

    private Map<String, MarketReqirement> marketReqirements = new HashMap<>();

    InMemoryMarketRequirementDao(){

        String[] europe = {"Austria","Belgium", "Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia","Spain","Sweden", "United Kingdom"};
        String[] latam = {"Brazil", "Mexico", "Colombia", "Argentina", "Peru", "Venezuela", "Chile", "Ecuador", "Guatemala", "Cuba", "Haiti"};
        String[] na = {"United States", "Canada", "Mexico"};

        for(String country: europe){
            upsertMarketRequirement(new MarketReqirement(country+"-Domestic", "Europe", "GenericEurope"));
            upsertMarketRequirement(new MarketReqirement(country+"-Travel", "World Travel", "GenX"));
        }

        upsertMarketRequirement(new MarketReqirement("France-Domestic", "Europe", "France"));
        upsertMarketRequirement(new MarketReqirement("France-Travel", "World Travel", "GenX"));

        for(String country: latam){
            upsertMarketRequirement(new MarketReqirement(country+"-Domestic", "LatAm", "GenX"));
            upsertMarketRequirement(new MarketReqirement(country+"-Travel", "World Travel", "GenX"));
        }

        for(String country: na){
            upsertMarketRequirement(new MarketReqirement(country+"-Domestic", "NA", "USFDA"));
            upsertMarketRequirement(new MarketReqirement(country+"-Travel", "World Travel", "GenX"));
        }
    }

    @Override
    public Collection<MarketReqirement> getMarketRequirements() {
        return marketReqirements.values();
    }

    @Override
    public MarketReqirement getMarketRequirement(String market) {
        return marketReqirements.get(market);
    }

    @Override
    public void upsertMarketRequirement(MarketReqirement marketReqirement) {
        marketReqirements.put(marketReqirement.getMarket(), marketReqirement);
    }
}
