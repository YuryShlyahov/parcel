package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelTest {

    private static StandardParcel standardParcel;
    private static FragileParcel fragileParcel;
    private static PerishableParcel perishableParcel;

    @BeforeAll
    public static void beforeAll() {
        standardParcel = new StandardParcel("Обычная посылка", 100, "г. Москва, ул. Ак.Королева, д. 25, кв. 1", 1);
        fragileParcel = new FragileParcel("Мамин хрусталь", 100, "г. Новосибирск, ул. Петрова, д. 6, кв. 7", 2);
        perishableParcel = new PerishableParcel("Бабушкин пирог", 100, "г. Оребург, ул. Пуховая, д. 2, кв. 1", 20, 5);
    }

    @Test
    public void standardParcelCostTestShouldReturnEquals() {
        assertEquals(200, standardParcel.calculateDeliveryCost(), "Стоимость стандартной посылки вычисляется неверно");
    }

    @Test
    public void fragileParcelCostTestShouldReturnEquals() {
        assertEquals(400, fragileParcel.calculateDeliveryCost(), "Стоимость хрупкой посылки вычисляется неверно");
    }

    @Test
    public void perishableParcelCostTestShouldReturnEquals() {
        assertEquals(300, perishableParcel.calculateDeliveryCost(), "Стоимость скоропортящейся посылки вычисляется неверно");
    }

    @Test
    public void perishableParcelIsExpiredTestShouldReturnTrue() {

        assertTrue(perishableParcel.isExpired(26));
    }
    @Test
    public void perishableParcelIsExpiredTestShouldReturnFalse() {
        assertFalse(perishableParcel.isExpired(25));
    }
}