package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            mScore1 += 1;
        } else {
            mScore2 += 1;
        }
    }

    @Override
    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (mScore1 == mScore2) {
            if (mScore1 == 0) {
                score = "Love-All";
            } else if (mScore1 == 1) {
                score = "Fifteen-All";
            } else if (mScore1 == 2) {
                score = "Thirty-All";
            } else {
                score = "Deuce";
            }
        } else if (mScore1 >= 4 || mScore2 >= 4) {
            int minusResult = mScore1 - mScore2;
            if (minusResult == 1) {
                score = "Advantage player1";
            } else if (minusResult == -1) {
                score = "Advantage player2";
            } else if (minusResult >= 2) {
                score = "Win for player1";
            } else {
                score = "Win for player2";
            }
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = mScore1;
                } else {
                    score += "-";
                    tempScore = mScore2;
                }
                if (tempScore == 0) {
                    score += "Love";
                } else if (tempScore == 1) {
                    score += "Fifteen";
                } else if (tempScore == 2) {
                    score += "Thirty";
                } else if (tempScore == 3) {
                    score += "Forty";
                }
            }
        }
        return score;
    }
}