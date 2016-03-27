package uk.org.wetdreams.skued.service.aggregator;

import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.service.domain.MarketReqirement;
import uk.org.wetdreams.skued.service.domain.RegionalMarketRequirement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class RegionAggregator {

    public static Collection<RegionalMarketRequirement> aggregateMarketRequirements(Collection<MarketReqirement> marketReqirements){
        Map<String,RegionalMarketRequirement> result = new HashMap<>();
        for(MarketReqirement reqirement:marketReqirements){
            if(result.containsKey(reqirement.getMarketGroup())){
                result.get(reqirement.getMarketGroup()).addMarketRequirement(reqirement);
            } else {
                result.put(reqirement.getMarketGroup(),new RegionalMarketRequirement(reqirement));
            }
        }
        return result.values();
    }

}
