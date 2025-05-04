package Cricbuzz.observer;

import Cricbuzz.team.BattingTeam;
import Cricbuzz.team.BowlingTeam;

public interface MatchStatsObserval {
    public void addMatchStatObserver(MatchStatsObserver observer);
    public void notifyObservers();
    public void updateTeamStats(BattingTeam battingTeam, BowlingTeam bowlingTeam);
}
