package cn.xpbootcamp.tennis.game3;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 extends TennisGame {
    public TennisGame3(String player1Name, String player2Name) {
        super(player1Name, player2Name);
    }

    @Override
    public String getScore() {
        String s;
        if (isScoreEqual()) {
            return equalScore();
        }

        if (p1point >= 4 || p2point >= 4 || p1point + p2point == 6) {
            s = p1point > p2point ? player1Name : player2Name;
            return ((p1point - p2point)*(p1point - p2point) == 1) ? "Advantage " + s : "Win for " + s;
        } else {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[p1point];
            return s + "-" + p[p2point];
        }
    }
}