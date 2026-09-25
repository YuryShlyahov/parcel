package org.example;

public class PerishableParcel extends Parcel {
    private static final double BASE_COST = 3.0;
    private final int timeToLive;

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
        return BASE_COST;
    }
}
