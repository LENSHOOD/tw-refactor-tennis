package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 extends TennisGame {
    public TennisGame1(String player1Name, String player2Name) {
        super(player1Name, player2Name);
    }

    @Override
    public String getScore() {
        String score = "";
        if (isScoreEqual()) {
            score = equalScore();
        } else if (isScore1GreaterThan4()) {
            score = winnerScore();
        } else if (isScore2GreaterThan4()) {
            score = winnerScore();
        } else {
            score = calculateScore(score);
        }
        return score;
    }

    private String calculateScore(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = p1point;
            } else {
                score += "-";
                tempScore = p2point;
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
        return score;
    }

    private String winnerScore() {
        String score;
        int minusResult = p1point - p2point;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    private String equalScore() {
        String score;
        if (p1point == 0) {
            score = "Love-All";
        } else if (p1point == 1) {
            score = "Fifteen-All";
        } else if (p1point == 2) {
            score = "Thirty-All";
        } else {
            score = "Deuce";
        }
        return score;
    }

    private boolean isScore2GreaterThan4() {
        return p2point >= 4;
    }

    private boolean isScore1GreaterThan4() {
        return p1point >= 4;
    }

    private boolean isScoreEqual() {
        return p1point == p2point;
    }
}