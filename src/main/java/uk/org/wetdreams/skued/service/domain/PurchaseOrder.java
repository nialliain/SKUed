package uk.org.wetdreams.skued.service.domain;

public class PurchaseOrder {

    private String skuType;
    private long qty;

    public PurchaseOrder(String skuType, long qty){
        this.skuType = skuType;
        this.qty = qty;
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

    public void incrementOrder(long qty) {
        this.qty += qty;
    }
}
