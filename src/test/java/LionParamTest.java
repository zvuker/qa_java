package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {
    private final String lionSex;
    private final boolean hasMane;


    public LionParamTest(String lionSex, boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void hasMane() throws Exception {
        //arrange
        Feline feline = new Feline();
        Lion lion = new Lion(lionSex, feline);
        //act
        boolean actual = lion.doesHaveMane();
        //assert
        assertEquals("Неправильное значение в hasMane", hasMane, actual);
    }
}