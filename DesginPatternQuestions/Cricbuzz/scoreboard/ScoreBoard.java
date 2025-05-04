package Cricbuzz.scoreboard;

import Cricbuzz.observer.MatchStatsObserver;
import Cricbuzz.players.Player;
import Cricbuzz.team.BattingTeam;
import Cricbuzz.team.BowlingTeam;

public class ScoreBoard implements MatchStatsObserver{
    private BattingTeam battingTeam;
    private BowlingTeam bowlingTeam;

    public ScoreBoard(BattingTeam battingTeam, BowlingTeam bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
    }

    private Player getStriker() {
        return battingTeam.getStriker();
    }

    private Player getNonStriker() {
        return battingTeam.getNonStriker();
    }

    private Player getBowler() {
        return bowlingTeam.getCurrentBowler();
    }

    @Override
    public void updateBatAndBowlStats(BattingTeam battingTeam, BowlingTeam bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
    }

    public void displayScoreCard() {
        StringBuilder res = new StringBuilder();
        Player striker = getStriker();
        Player nonStriker = getNonStriker();
        Player bowler = getBowler();

        res.append("TeamScore: ").append(battingTeam.getTotalRunsScored())
        .append("\n\n")
        .append(" Striker -> PlayerName:").append(striker.getPlayerName())
        .append(" - ").append(striker.getRunsMade()).append(", SR:").append(striker.getStrikeRate())
        .append("\n")
        .append("Non-Striker -> PlayerName:").append(nonStriker.getPlayerName())
        .append(" - ").append(nonStriker.getRunsMade()).append(", SR:").append(nonStriker.getStrikeRate())
        .append("\n\n")
        .append("Bowler-> PlayerName :").append(bowler.getPlayerName()).append(" over:").append(bowler.getTotalBallsBowled())
        .append(", Eco:").append(bowler.getEconomy());

        System.out.println("------------------SCORE CARD---------------");
        System.out.println(res.toString());
    }
}
