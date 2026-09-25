package org.example;

public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;
    private static final double BASE_COST = 0;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public String getDescription() {
        return description;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void packageItem(){
        System.out.println("Посылка <<" + getDescription() + ">> упакована");
    }
    public void deliver(){
        System.out.println("Посылка <<" + getDescription() + ">> доставлена по адресу "  + getDeliveryAddress());
    }

    public double calculateDeliveryCost(){
        return BASE_COST*getWeight();
    }
}
