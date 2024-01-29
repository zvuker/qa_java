package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AnimalTest {
    @Test()
    public void getFoodReturnException() throws Exception {
        //arrange
        Animal animal = new Animal();
        String badFoodRequest = "asd";
        try {
            //act
            animal.getFood(badFoodRequest);
            Assert.fail("Exception thrown");
        } catch (Exception thrown) {
            //assert
            assertNotEquals(badFoodRequest, thrown.getMessage());
        }
    }

    @Test
    public void getFamilyCorrectReturnValue() {
        //arrange
        Animal animal = new Animal();
        //act
        String actualFamily = animal.getFamily();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        //assert
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getFoodValueOfHerbivoreReturn() throws Exception {
        //arrange
        Animal animal = new Animal();
        //act
        List<String> expectedEat = List.of("Трава", "Различные растения");
        List<String> actualEat = animal.getFood("Травоядное");
        //assert
        assertEquals(expectedEat, actualEat);
    }

}