package org.example;

public class FragileParcel extends Parcel implements Trackable{

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
        baseCost = 4;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + getDescription() + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + getDescription() + ">> изменила местоположение на " + newLocation);
    }
}
