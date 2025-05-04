package Cricbuzz.players;

public class Bowler extends Player {
    private int wicketsTaken;
    private PlayerStatus status;

    public Bowler(PlayerType type, String name, int jerseyNumber) {
        super(type, name, jerseyNumber);
        status = PlayerStatus.YET_TO_BOWL;
    }

    public PlayerStatus getBowlingStatus() {
        return status;
    }

    public void setBowlingStatus(PlayerStatus status) {
        this.status = status;
    }

    public void addWickets() {
        this.wicketsTaken++;
    }

    public int getWickets() {
        return this.wicketsTaken;
    }
}
