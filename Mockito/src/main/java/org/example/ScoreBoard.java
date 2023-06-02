package org.example;

public class ScoreBoard {

    //initialize variables
    private Integer tie;
    private Integer win;
    private Integer losses;

    public ScoreBoard() {
        tie = 0;
        win = 0;
        losses = 0;
    }

    public Integer getTie() {
        return tie;
    }

    public Integer getWin() {
        return win;
    }

    public Integer getLosses() {
        return losses;
    }

    public void addTie() {
        tie++;
    }

    public void addWin() {
        win++;
    }

    public void addLosses() {
        losses++;
    }
}
