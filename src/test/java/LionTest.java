package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test()
    public void lionSexHaveException() throws Exception {
        //arrange
        try {
            Lion lion = new Lion(" ", feline);
            //act
            lion.doesHaveMane();
        } catch (Exception thrown) {
            //assert
            assertNotEquals(" ", thrown.getMessage());
        }
    }

    @Test()
    public void lionConstructorIncorrectSexReturnExceptionText() throws Exception {
        //arrange
        String sex = "asd";
        //act
        try {
            Lion lion = new Lion(sex, feline);
            Assert.fail("Exception thrown");
        } catch (Exception thrown) {
            //assert
            assertNotEquals(sex, thrown.getMessage());
        }
    }

    @Test
    public void isLionHaveManeTrue() throws Exception {
        //arrange
        Lion lion = new Lion("Самец", feline);
        //act
        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        //assert
        assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void getKittensReturnFelineGetKittens() throws Exception {
        //arrange
        Lion lion = new Lion("Самец", feline);
        //act
        Mockito.when(feline.getKittens()).thenReturn(1);
        //assert
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getLionEatAnatherMeat() throws Exception {
        //arrange
        Lion lion = new Lion("Самец", feline);
        //act
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Рыба", "Птицы"));
        List<String> expectedEatMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualEatMeat = lion.getFood();
        //assert
        assertTrue(expectedEatMeat.size() == actualEatMeat.size() && expectedEatMeat.containsAll(actualEatMeat) && actualEatMeat.containsAll(expectedEatMeat));
    }

    @Test
    public void getLionEatMeat() throws Exception {
        //arrange
        Lion lion = new Lion("Самец", feline);
        //act
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedEatMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualEatMeat = lion.getFood();
        //assert
        assertEquals(expectedEatMeat, actualEatMeat);
    }
}