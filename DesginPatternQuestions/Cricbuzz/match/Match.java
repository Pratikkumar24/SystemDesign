package Cricbuzz.match;

import Cricbuzz.scoreboard.ScoreBoard;

public class Match{
    public static Match instance;
    private ScoreBoard scoreBoard;
    private MatchType matchType;
    private int targetScore;
    private MatchInning matchInning;

    public static Match getInstance() {
        if(instance == null) {
            synchronized(Match.class) {
                instance = new Match();
            }
        }
        return instance;
    }

    public MatchInning getMatchInning() {
        return this.matchInning;
    }

    public void setMatchInning(MatchInning inning) {
        this.matchInning = inning;
    }

    public void setTargetScore(int score) {
        this.targetScore = score;
    }

    public int getTargetScore() {
        return this.targetScore;
    }

    public void setMatchType(MatchType type) {
        this.matchType = type;
    }

    public MatchType getMatchType() {
        return this.matchType;
    }

    public void updateScoreBoard(ScoreBoard board) {
        this.scoreBoard = board;
    }

    public void showScoreCard() {
        this.scoreBoard.displayScoreCard();
    }
}
