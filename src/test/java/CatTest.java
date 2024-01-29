package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void GetFoodMethodTest() throws Exception {
        //arrange
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        //act
        List<String> actualFood = cat.getFood();
        //assert
        Assert.assertEquals("Еда не соответствует виду животного", expectedFood, actualFood);
    }

    @Test
    public void catGedFoodLikePredatorMockTest() throws Exception {
        //arrange
        Cat cat = new Cat(feline);
        //act
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Бургеры", "Пицца", "Шаверма"));
        //assert
        Assert.assertEquals(Arrays.asList("Бургеры", "Пицца", "Шаверма"), cat.getFood());
    }

    @Test
    public void getCatSoundReturn() {
        //arrange
        Cat cat = new Cat(feline);
        String expectedCatSound = "Мяу";
        //act
        String actualGetSound = cat.getSound();
        //assert
        Assert.assertEquals("Кот издал не Мяу", expectedCatSound, actualGetSound);
    }
}
