package uk.org.wetdreams.skued.service.dao.market;

import uk.org.wetdreams.skued.service.domain.MarketReqirement;

import java.util.Collection;

public interface MarketRequirementDao {

    Collection<MarketReqirement> getMarketRequirements();

    MarketReqirement getMarketRequirement(String market);

    void upsertMarketRequirement(MarketReqirement marketReqirement);
}