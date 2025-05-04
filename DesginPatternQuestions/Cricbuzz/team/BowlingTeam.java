package Cricbuzz.team;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.players.Bowler;
import Cricbuzz.players.Player;

public class BowlingTeam extends Team {

    private int totalWicketTaken;
    private Bowler currentBowler;

    public BowlingTeam(TeamStatus status, String teamName) {
        super(status, teamName);
    }

    public List<Bowler> getListOfBowlers() {
        List<Bowler> bowlers = new ArrayList<>();
        for (Player player : players) {
            if (player instanceof Bowler) {
                bowlers.add((Bowler) player);
            }
        }
        return bowlers;
    }
    
    public void addTeamWicket() {
        totalWicketTaken++;
        currentBowler.addWickets();
    }

    public void setCurrentBowler(Bowler player) {
        this.currentBowler = player;
    }

    public int getTotalWicketTakenByTeam() {
        return this.totalWicketTaken;
    }

    public Bowler getCurrentBowler() {
        return this.currentBowler;
    }
}
