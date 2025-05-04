package Cricbuzz.observer;

import Cricbuzz.team.BattingTeam;
import Cricbuzz.team.BowlingTeam;

public interface MatchStatsObserver {
    public void updateBatAndBowlStats(BattingTeam battingTeam, BowlingTeam bowlingTeam);
}
