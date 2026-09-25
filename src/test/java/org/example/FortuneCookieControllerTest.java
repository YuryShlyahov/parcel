package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FortuneCookieControllerTest {

    private static FortuneCookieController goodFactoryController;
    private static FortuneCookieController badFactoryController;

    @BeforeAll
    public static void beforeAll() {
        goodFactoryController = create(true);
        badFactoryController = create(false);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        assertEquals("positive", goodFactoryController.tellFortune().getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        assertEquals("negative", badFactoryController.tellFortune().getFortuneText());
    }

    private static FortuneCookieController create(boolean isPositive) {
        final FortuneConfig config = new FortuneConfig(isPositive);
        ArrayList<String> positive = new ArrayList<>();
        positive.add("positive");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("negative");
        FortuneCookieFactory factory = new FortuneCookieFactory(
                config,
                positive,
                negative
        );
        return new FortuneCookieController(factory);
    }
}