package uk.org.wetdreams.skued.service.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MarketReqirement {

    private String market;
    private String skuType;

    public MarketReqirement(String market, String skuType){
        this.market = market;
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
}
