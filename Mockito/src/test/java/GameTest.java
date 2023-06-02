import org.example.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;
    @InjectMocks
    Game game = new Game();

    @Mock
    Scanner scanner;

    @Mock
    Random random;

    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void when_writeQuit_then_exitGame() {
        when(scanner.nextLine()).thenReturn("Quit");

        game.play();

        Assert.assertTrue(outContent.toString().contains("Let's play Rock, Paper, Scissors!"));
    }

    @Test
    public void when_chooseRock_then_beatsScissors() {
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_SCISSORS);

        game.play();

        Assert.assertTrue(outContent.toString().contains("Computer chose scissors"));
        Assert.assertTrue(outContent.toString().contains("wins:1"));
    }

    @Test
    public void when_chooseScissors_then_beatsPaper() {
        when(scanner.nextLine()).thenReturn("Scissors", "Quit");
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);

        game.play();

        Assert.assertTrue(outContent.toString().contains("Computer chose paper"));
        Assert.assertTrue(outContent.toString().contains("wins:1"));
    }

    @Test
    public void when_choosePaper_then_beatsRock() {
        when(scanner.nextLine()).thenReturn("Paper", "Quit");
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);

        game.play();

        Assert.assertTrue(outContent.toString().contains("Computer chose rock"));
        Assert.assertTrue(outContent.toString().contains("wins:1"));
    }

    @Test
    public void when_bothChoose_then_tie() {
        when(scanner.nextLine()).thenReturn("Rock", "Quit");
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);

        game.play();

        Assert.assertTrue(outContent.toString().contains("Computer chose rock"));
        Assert.assertTrue(outContent.toString().contains("ties:1"));
    }

    @Test
    public void when_chooseRockAndComputerChoosePaper_then_lose() {
        when(scanner.nextLine()).thenReturn("Rock", "Quit");
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);

        game.play();

        Assert.assertTrue(outContent.toString().contains("Computer chose paper"));
        Assert.assertTrue(outContent.toString().contains("loses:1"));
    }

}
