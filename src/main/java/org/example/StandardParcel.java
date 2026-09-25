package org.example;

public class StandardParcel extends Parcel {

    private static final double BASE_COST = 2.0;
    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double getBaseCost() {
        return BASE_COST;
    }
}
