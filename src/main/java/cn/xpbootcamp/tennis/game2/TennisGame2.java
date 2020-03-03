package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 extends TennisGame {
    private String p1Res = "";
    private String p2Res = "";

    public TennisGame2(String player1Name, String player2Name) {
        super(player1Name, player2Name);
    }

    @Override
    public String getScore() {
        String score = "";
        if (isScoreEqual()) {
            score = equalScore(score);
        }

        if (p1point > p2point) {
            if (p2point == 0) {
                p1Res = getScoreByPoint(p1point);
                p2Res = getScoreByPoint(p2point);
                score = p1Res + "-" + p2Res;
            }
            if (p2point >= 3) {
                score = "Advantage player1";
            }
            if (p1point < 4) {
                p1Res = getScoreByPoint(p1point);
                p2Res = getScoreByPoint(p2point);
                score = p1Res + "-" + p2Res;
            }
            if (p1point >= 4 && p2point >= 0) {
                if ((p1point - p2point) >= 2) {
                    score = "Win for player1";
                }
            }
        }

        if (p2point > p1point) {
            if (p1point == 0) {
                p2Res = getScoreByPoint(p2point);
                p1Res = getScoreByPoint(p2point);
                score = p1Res + "-" + p2Res;
            }
            if (p2point < 4) {
                p2Res = getScoreByPoint(p2point);
                p1Res = getScoreByPoint(p1point);
                score = p1Res + "-" + p2Res;
            }
            if (p1point >= 3) {
                score = "Advantage player2";
            }
            if (p2point >= 4 && p1point >= 0) {
                if ((p2point - p1point) >= 2) {
                    score = "Win for player2";
                }
            }
        }

        return score;
    }

    private String getScoreByPoint(int point) {
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

    private String equalScore(String score) {
        if (p1point < 4) {
            score = getScoreByPoint(p1point);
            score += "-All";
        }
        if (p1point >= 3) {
            score = "Deuce";
        }
        return score;
    }

    private boolean isScoreEqual() {
        return p1point == p2point;
    }
}