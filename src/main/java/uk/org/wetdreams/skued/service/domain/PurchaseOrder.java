package uk.org.wetdreams.skued.service.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder {

    private String skuType;
    private long qty;
    private List<String> markets;

    public PurchaseOrder(String skuType, long qty, String market){
        this.skuType = skuType;
        this.qty = qty;
        markets = new ArrayList<>();
        this.addMarket(market);
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    public void incrementOrder(long qty, String market) {
        this.qty += qty;
        this.addMarket(market);
    }

    public List<String> getMarkets() {
        return markets;
    }

    private void addMarket(String market) {
        markets.add(market);
    }
}
