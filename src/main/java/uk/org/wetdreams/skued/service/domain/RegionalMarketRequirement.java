package uk.org.wetdreams.skued.service.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class RegionalMarketRequirement {

    private String marketGroup;
    private List<MarketReqirement> marketReqirements;

    public RegionalMarketRequirement(MarketReqirement reqirement){
        this.marketGroup = reqirement.getMarketGroup();
        marketReqirements = new ArrayList<>();
        marketReqirements.add(reqirement);
    }

    public void addMarketRequirement(MarketReqirement reqirement){
        marketReqirements.add(reqirement);
    }

    public String getMarketGroup() {
        return marketGroup;
    }

    public List<MarketReqirement> getMarketReqirements() {
        return marketReqirements;
    }
}
