package pl.msoroka.javaee.zad03.domain;

import java.util.Date;

public class Plane {
    private String producer;
    private Date productionDate;
    private boolean vipStatus;
    private double combustion;

    public Plane() {
        super();
    }

    public Plane(String producer, Date productionDate, double combustion, boolean vipStatus) {
        this.producer = producer;
        this.productionDate = productionDate;
        this.combustion = combustion;
        this.vipStatus = vipStatus;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProdutionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public boolean isVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(boolean vipStatus) {
        this.vipStatus = vipStatus;
    }

    public double getCombustion() {
        return combustion;
    }

    public void setCombustion(double combustion) {
        this.combustion = combustion;
    }
}
