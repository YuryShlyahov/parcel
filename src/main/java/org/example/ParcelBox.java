package org.example;

import java.util.ArrayList;
import java.util.List;

public final class ParcelBox<T extends Parcel> {
    private List<T> parcelsInBox = new ArrayList<>();
    private final int maxWeight;
    private int weight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        weight = 0;
    }

    public int getWeight() {
        return weight;
    }

    public void addParcel(T parcel) {
        if (weight + parcel.getWeight() > maxWeight) {
            System.out.println("Ошибка, посылка не добавлена, превышен максимальный вес коробки.");
        } else {
            parcelsInBox.add(parcel);
            weight += parcel.getWeight();
            System.out.println("Посылка " + parcel.getDescription() + " добавлена в коробку.");
            System.out.println("В коробке осталось свободного места на " + (maxWeight - weight) + " г.");
        }
    }

    public List<T> getAllParcels() {
        return parcelsInBox;
    }
}
