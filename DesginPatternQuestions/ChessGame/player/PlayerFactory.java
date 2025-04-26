package player;

public class PlayerFactory {
    public PlayerStrategy getPlayerStrategy(String strategy) {
        switch(strategy) {
            case "human": return new Human();
            case "ai": return new Ai();
        }
        return null;
    }
}
