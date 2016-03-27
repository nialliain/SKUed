package uk.org.wetdreams.skued.service.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MarketReqirement {

    private String market;
    private String marketGroup;
    private String skuType;

    public MarketReqirement(){
    }

    public MarketReqirement(String market, String marketGroup, String skuType){
        this.market = market;
        this.marketGroup = marketGroup;
        this.skuType = skuType;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    @Override
    public String toString(){
        return "MarketReqirement: {market = " + market + ", marketGroup = " + marketGroup + ", skuType = " + skuType + "}";
    }

    public String getMarketGroup() {
        return marketGroup;
    }

    public void setMarketGroup(String marketGroup) {
        this.marketGroup = marketGroup;
    }
}
