package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    List<T> parcelsInBox =new ArrayList<>();
    int maxWeight;
 }
