package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 extends TennisGame {
    public TennisGame2(String player1Name, String player2Name) {
        super(player1Name, player2Name);
    }

    @Override
    public String getScore() {
        if (isScoreEqual()) {
            return  equalScore();
        }

        if (p1point > p2point) {
            return leadPlayer(p1point, p2point, player1Name);
        }

        return leadPlayer(p2point, p1point, player2Name);
    }

    private String leadPlayer(int leadPoint, int behindPoint, String playerName) {
        if (leadPoint >= 4) {
            if ((leadPoint - behindPoint) >= 2) {
                return "Win for " + playerName;
            }
            return "Advantage " + playerName;
        }

        return getScoreByPoint(p1point) + "-" + getScoreByPoint(p2point);
    }
}