package Cricbuzz.players;

public class Batsman extends Player{

    private PlayerStatus status;

    public Batsman(PlayerType type, String name, int jerseyNumber) {
        super(type, name, jerseyNumber);
        status = PlayerStatus.NOT_OUT;
    }
    
    public void setPlayerStatus(PlayerStatus status) {
        this.status = status;
    }

    public PlayerStatus getPlayerStatus() {
        return this.status;
    }
}
