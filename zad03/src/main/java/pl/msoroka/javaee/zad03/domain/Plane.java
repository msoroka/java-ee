package pl.msoroka.javaee.zad03.domain;

import java.util.Date;

public class Plane {
    private int id;
    private String producer;
    private Date productionDate;
    private boolean vipStatus;
    private double combustion;
    private int price;
    private int quantity;

    public Plane() {
        super();
    }

    public Plane(int id, String producer, Date productionDate, double combustion, boolean vipStatus, int price, int quantity) {
        this.id = id;
        this.producer = producer;
        this.productionDate = productionDate;
        this.combustion = combustion;
        this.vipStatus = vipStatus;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementId() {
        id++;
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
