package Cricbuzz.team;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.players.Player;

public class Team {
    private String teamName;
    protected List<Player> players;
    private TeamStatus status;

    public Team(TeamStatus status, String teamName) {
        players = new ArrayList<>();
        this.status = status;
        this.teamName = teamName;
    }

    public void addPlayer(List<Player> player) {
        players.addAll(player);
    }

    public void setTeamStatus(TeamStatus status) {
        this.status = status;
    }

    public TeamStatus getTeamStatus() {
        return status;
    }    

    public String getTeamName() {
        return teamName;
    }
}
