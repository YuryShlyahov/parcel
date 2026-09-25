package org.example;

public class PerishableParcel extends Parcel {

    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public boolean isExpired(int currentDay) {
        if (getSendDay() + getTimeToLive() >= currentDay) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public double getBaseCost() {
        return 3.0;
    }
}
