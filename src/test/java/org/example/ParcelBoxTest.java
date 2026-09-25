package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelBoxTest {
    static ParcelBox<StandardParcel> standardParcelParcelBox;
    static StandardParcel smallParcel;
    static StandardParcel bigParcel;
    static StandardParcel maxParcel;

    @BeforeEach
    public void beforeEach() {
        standardParcelParcelBox = new ParcelBox<>(100);
        smallParcel = new StandardParcel("Маленькая посылка", 10, "г. Москва, ул. Ак.Королева, д. 25, кв. 1", 1);
        bigParcel = new StandardParcel("Большая посылка", 1000, "г. Москва, ул. Ак.Королева, д. 25, кв. 1", 2);
        maxParcel = new StandardParcel("Посылка максимального веса", 100, "г. Москва, ул. Ак.Королева, д. 25, кв. 1", 2);
    }

    @Test
    public void addingParcelToBoxShouldIncreaseWeight() {
        standardParcelParcelBox.addParcel(smallParcel);
        assertEquals(standardParcelParcelBox.getWeight(), smallParcel.getWeight());
    }

    @Test
    public void overloadBoxShouldNotChangeWeight() {
        standardParcelParcelBox.addParcel(bigParcel);
        assertEquals(0, standardParcelParcelBox.getWeight());
    }

    @Test
    public void addingMaxWeightShouldIncreaseWeight() {
        standardParcelParcelBox.addParcel(maxParcel);
        assertEquals(100, standardParcelParcelBox.getWeight());
    }

}
