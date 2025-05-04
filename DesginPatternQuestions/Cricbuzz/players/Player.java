package Cricbuzz.players;

public abstract class Player {
    private String name;
    private int jerseyNumber;
    private int runsMade;
    private int ballsPlayed;

    private int runsGiven;
    private int totalBallsBowled;

    private PlayerType playerType;

    public Player(PlayerType type, String name, int jerseyNumber) {
        this.playerType = type;
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    public String getPlayerName() {
        return name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }
    public int getRunsMade() {
        return this.runsMade;
    }

    public void addRuns(int run) {
        this.runsMade += run;
        this.ballsPlayed++;
    }

    public void runsGiven(int run) {
        this.runsGiven += run;
        this.totalBallsBowled++;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }

    public Double getStrikeRate() {
        return (double)(runsMade)/ballsPlayed;
    }

    public String getTotalBallsBowled() {
        StringBuilder res = new StringBuilder();
        res.append(totalBallsBowled/6).append('.').append(totalBallsBowled%6);
        return res.toString();
    }

    public Double getEconomy() {
        return (double)(runsGiven)/(double)(totalBallsBowled/6.0);
    }
}
