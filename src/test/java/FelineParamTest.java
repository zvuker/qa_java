package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {
    private final int countKittens;

    public FelineParamTest(int countKittens) {
        this.countKittens = countKittens;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getKittens() {
        return new Object[][]{
                {7},
                {3},
                {-4},
                {-7},
        };
    }

    @Test
    public void quantityMatchingKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens(countKittens);
        assertEquals("Количество не соответствует", countKittens, actual);
    }
}