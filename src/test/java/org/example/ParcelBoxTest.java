package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ParcelBoxTest {
    static ParcelBox<StandardParcel> standardParcelParcelBox;
    static StandardParcel smallParcel;
    static StandardParcel bigParcel;

    @BeforeEach
    public void beforeEach() {
        standardParcelParcelBox = new ParcelBox<>(100);
        smallParcel = new StandardParcel("Маленькая посылка", 10, "г. Москва, ул. Ак.Королева, д. 25, кв. 1", 1);
        bigParcel = new StandardParcel("Большая посылка", 1000, "г. Москва, ул. Ак.Королева, д. 25, кв. 1", 2);
    }

    @Test
    public void addingParcelToBoxShouldReturnTrue() {
        standardParcelParcelBox.addParcel(smallParcel);
        assertEquals(standardParcelParcelBox.getWeight(), smallParcel.getWeight());
    }

    @Test
    public void overloadBoxShouldReturnTrue() {
        standardParcelParcelBox.addParcel(bigParcel);
        assertEquals(standardParcelParcelBox.getWeight(), 0);
    }

}
