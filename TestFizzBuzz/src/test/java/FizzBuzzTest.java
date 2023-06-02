import org.example.FizzBuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FizzBuzzTest {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    private FizzBuzz game;
    @Before
    public void createFIZZBuzz() {
        game = new FizzBuzz();
    }
    // should return number when not divisible by 3 or 5
    @Test
    public void FIZZBuzzTest1() {
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals("1", numbersList.get(0));
        Assert.assertEquals("2", numbersList.get(1));
        Assert.assertEquals("7", numbersList.get(6));
        Assert.assertEquals("13", numbersList.get(12));
    }

    // should return FIZZ when divisible by 3
    @Test
    public void FIZZBuzzTest2() {
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(FIZZ, numbersList.get(2));
        Assert.assertEquals(FIZZ, numbersList.get(5));
        Assert.assertEquals(FIZZ, numbersList.get(8));
        Assert.assertEquals(FIZZ, numbersList.get(11));
    }

    // should return Buzz when divisible by 5
    @Test
    public void FIZZBuzzTest3() {
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(BUZZ, numbersList.get(4));
        Assert.assertEquals(BUZZ, numbersList.get(9));
        Assert.assertEquals(BUZZ, numbersList.get(19));
        Assert.assertEquals(BUZZ, numbersList.get(24));
    }

    // should return FIZZBuzz when divisible by 3 and 5
    @Test
    public void FIZZBuzzTest4() {
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(FIZZ + BUZZ, numbersList.get(14));
        Assert.assertEquals(FIZZ + BUZZ, numbersList.get(29));
        Assert.assertEquals(FIZZ + BUZZ, numbersList.get(44));
        Assert.assertEquals(FIZZ + BUZZ, numbersList.get(59));
    }
}
