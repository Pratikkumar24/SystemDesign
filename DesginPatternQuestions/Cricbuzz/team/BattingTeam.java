package Cricbuzz.team;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.players.Batsman;
import Cricbuzz.players.Player;

public class BattingTeam extends Team{

    private int totalRunsScored;
    private Batsman striker;
    private Batsman nonStriker;

    public BattingTeam(TeamStatus status, String teamName) {
        super(status, teamName);
    }
    
    public List<Batsman> getListOfBatsmans() {
        List<Batsman> batsmen = new ArrayList<>();
        for (Player player : players) {
            if (player instanceof Batsman) {
                batsmen.add((Batsman) player);
            }
        }
        return batsmen;
    }
    
    public int getTotalRunsScored() {
        return totalRunsScored;
    }

    public void setTotalRunsScored(int totalRunsScored) {
        this.totalRunsScored += totalRunsScored;
    }

    public Batsman getStriker() {
        return striker;
    }

    public void setStriker(Batsman striker) {
        this.striker = striker;
    }

    public Batsman getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Batsman nonStriker) {
        this.nonStriker = nonStriker;
    }
}
