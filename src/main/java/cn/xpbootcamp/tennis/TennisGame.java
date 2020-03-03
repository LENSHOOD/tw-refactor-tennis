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

    protected abstract String getScore();

    protected String getScoreByPoint(int point) {
        if (point == 0) {
            return "Love";
        }
        if (point == 1) {
            return "Fifteen";
        }
        if (point == 2) {
            return "Thirty";
        }
        if (point == 3) {
            return "Forty";
        }

        return "";
    }

    protected boolean isScoreEqual() {
        return p1point == p2point;
    }

    protected String equalScore() {
        if (p1point >= 3) {
            return "Deuce";
        }

        return getScoreByPoint(p1point) + "-All";
    }
}