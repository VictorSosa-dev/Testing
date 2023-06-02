package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        printGameRules();

        ScoreBoard scoreBoard = new ScoreBoard();
        String choice = input.nextLine().toUpperCase();

        while (!choice.equals("QUIT"))
        {
            GameOptions choicenum = getChoiceNum(choice);
            while(choicenum == null) {
                System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                choice = input.nextLine().toUpperCase();
                choicenum = getChoiceNum(choice);
            }

            GameOptions compnum = getComputerChoice();
            completeGame(scoreBoard, choicenum, compnum);
            printResults(scoreBoard);

            choice = input.nextLine().toUpperCase();
        }

    }

    private static void printResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWin() + "\nloses:" + scoreBoard.getLosses() + "\nties:" + scoreBoard.getTie()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private static void completeGame(ScoreBoard scoreBoard, GameOptions choicenum, GameOptions compnum) {
        if(choicenum == compnum) //tie cases
            tie(scoreBoard);
        else if (choicenum == GameOptions.ROCK && compnum == GameOptions.SCISSORS
            || choicenum == GameOptions.SCISSORS && compnum == GameOptions.PAPER
            || choicenum == GameOptions.PAPER && compnum == GameOptions.ROCK)
            wins(scoreBoard);

        lose(scoreBoard);

    }

    private static void lose(ScoreBoard scoreBoard) {
        System.out.println("you lose.");
        scoreBoard.addLosses();
    }

    private static void tie(ScoreBoard scoreBoard) {
        System.out.println("It's a tie");
        scoreBoard.addTie();
    }

    private static void wins(ScoreBoard scoreBoard) {
        System.out.println("you win!");
        scoreBoard.addWin();
    }

    private GameOptions getChoiceNum(String choice) {
        GameOptions selectedOption = null;

        if (choice.equals("quit"))
            System.exit(0);

        try {
            selectedOption = GameOptions.valueOf(choice.toUpperCase());
        } catch (Exception e) {
            System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
            return null;
        }

        return selectedOption;
    }

    private GameOptions getComputerChoice() {
        GameOptions options = GameOptions.values()[random.nextInt(3)];
        System.out.println("Computer chose " + options.toString().toLowerCase() + "\n");
        return options;
    }

    private static void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }
}
