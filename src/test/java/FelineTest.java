package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    @Test
    public void felineFoodTest() throws Exception {
        //arrange
        Feline feline = new Feline();
        //act
        List<String> actualFoodList = feline.eatMeat();
        List<String> expectedList = Arrays.asList("Животные", "Птицы", "Рыба");
        //assert
        assertEquals(expectedList, actualFoodList);
    }

    @Test
    public void felineFamalyTest() {
        //arrange
        Feline feline = new Feline();
        //act
        String actualFamaly = feline.getFamily();
        //assert
        assertEquals("Кошачьи", actualFamaly);
    }

    @Test
    public void felineKittensTest() {
        //arrange
        Feline feline = new Feline();
        //act
        int actualKittens = feline.getKittens();
        //assert
        assertEquals(1, actualKittens);
    }
}