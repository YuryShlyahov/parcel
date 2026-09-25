package org.example;

public class StandardParcel extends Parcel{


    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
        baseCost = 2;
    }
}
