package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 extends TennisGame {
    public TennisGame1(String player1Name, String player2Name) {
        super(player1Name, player2Name);
    }

    @Override
    public String getScore() {
        if (isScoreEqual()) {
            return equalScore();
        }

        if (hasScoreGreaterThan4()) {
            return winnerScore();
        }

        return mergeScore();
    }

    private boolean hasScoreGreaterThan4() {
        return p2point >= 4 || p1point >= 4;
    }

    private String  winnerScore() {
        int minusResult = p1point - p2point;
        if (minusResult == 1) {
            return "Advantage " + player1Name;
        }
        if (minusResult == -1) {
            return  "Advantage " + player2Name;
        }
        if (minusResult >= 2) {
            return  "Win for " + player1Name;
        }

        return "Win for " + player2Name;
    }

    private String mergeScore() {
        return getScoreByPoint(p1point) + "-" + getScoreByPoint(p2point);
    }
}