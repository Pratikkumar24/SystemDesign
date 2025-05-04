package Cricbuzz.observer;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.team.BattingTeam;
import Cricbuzz.team.BowlingTeam;

public class ObservalImpl implements MatchStatsObserval{

    List<MatchStatsObserver> listOfMatchStatObserver;
    BattingTeam battingTeam;
    BowlingTeam bowlingTeam;

    public ObservalImpl() {
        listOfMatchStatObserver = new ArrayList<>();
    }

    @Override
    public void addMatchStatObserver(MatchStatsObserver observer) {
        listOfMatchStatObserver.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(MatchStatsObserver observer: listOfMatchStatObserver) {
            observer.updateBatAndBowlStats(this.battingTeam, this.bowlingTeam);
        }
    }
    
    @Override
    public void updateTeamStats(BattingTeam battingTeam, BowlingTeam bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        /** Updating notify observer */
        this.notifyObservers();
    }
}
