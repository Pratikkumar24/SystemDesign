package Cricbuzz.factory;

import Cricbuzz.players.AllRounder;
import Cricbuzz.players.Batsman;
import Cricbuzz.players.Bowler;
import Cricbuzz.players.Player;
import Cricbuzz.players.PlayerType;

public class PlayerTypeFactory {
    public Player getPlayerByType(PlayerType playerType, String name, int jerseyNumber) {
        switch (playerType) {
            case BATSMAN:
                return new Batsman(playerType, name, jerseyNumber);
            case BOWLER:
                return new Bowler(playerType, name, jerseyNumber);
            case ALL_ROUNDER:
                return new AllRounder(playerType, name, jerseyNumber);
            default:
                return null;
        }
    }
}
