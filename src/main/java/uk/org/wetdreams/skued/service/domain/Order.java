package uk.org.wetdreams.skued.service.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

    private String market;
    private long qty;

    public Order(){

    }

    public Order(String market, long qty){
        this.market = market;
        this.qty = qty;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    @Override
    public String toString(){
        return "Order: {market = " + market + ", qty = " + qty + "}";
    }
}
