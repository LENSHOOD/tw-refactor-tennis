package cn.xpbootcamp.tennis;

public abstract class TennisGame {
    protected String player1Name;
    protected String player2Name;

    protected int p1point = 0;
    protected int p2point = 0;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            p1point += 1;
        } else {
            p2point += 1;
        }
    }
    abstract protected String getScore();
}