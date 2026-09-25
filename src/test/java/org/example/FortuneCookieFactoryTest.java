package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FortuneCookieFactoryTest {
    private final static ArrayList<String> positiveTexts = new ArrayList<>();
    private final static ArrayList<String> negativeTexts = new ArrayList<>();
    private final static FortuneConfig config = new FortuneConfig(true);
    FortuneCookieFactory factory;


    @BeforeEach
    void beforeEach() {
        positiveTexts.add("positive");
        negativeTexts.add("negative");
        factory = new FortuneCookieFactory(config, positiveTexts, negativeTexts);
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked(){
        int index = factory.getCookiesBaked();
        factory.bakeFortuneCookie();
        int increasedIndex = factory.getCookiesBaked();
        assertEquals((index + 1), increasedIndex);

    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        int index = factory.getCookiesBaked();
        factory.bakeFortuneCookie();
        factory.bakeFortuneCookie();
        int increasedIndex = factory.getCookiesBaked();
        assertEquals((index + 2), increasedIndex);
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall(){
        factory.bakeFortuneCookie();
        factory.bakeFortuneCookie();
        factory.resetCookiesCreated();
        assertEquals(0, factory.getCookiesBaked());
    }
}