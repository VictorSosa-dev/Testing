import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Game;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameSteps {

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
        MockitoAnnotations.initMocks(this);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Given("the user will choose {string}")
    public void theUserWillChoose(String userOption) {
        when(scanner.nextLine()).thenReturn(userOption).thenReturn("Quit");
    }

    @And("the computer will choose {string}")
    public void theComputerWillChoose(String computerSelection) {
        int selection = 0;
        if ("scissors".equals(computerSelection)) {
            selection = OPTION_SCISSORS;
        }
        if ("rock".equals(computerSelection)) {
            selection = OPTION_ROCK;
        }
        if ("paper".equals(computerSelection)) {
            selection = OPTION_PAPER;
        }
        when(random.nextInt(3)).thenReturn(selection);
    }


    @When("they play")
    public void theyPlay() {
        game.play();
    }

    @And("the user wins")
    public void theUserWins() {
        Assert.assertTrue(outContent.toString().contains("wins:1"));
    }

    @Then("verify that the computer chose {string}")
    public void verifyThatTheComputerChose(String computerSelection) {
        Assert.assertTrue(outContent.toString().contains("Computer chose " + computerSelection));
    }

    @And("the user lose")
    public void theUserLose() {
        Assert.assertTrue(outContent.toString().contains("loses:1"));
    }

    @And("the user tie")
    public void theUserTie() {
        Assert.assertTrue(outContent.toString().contains("ties:1"));
    }
}
