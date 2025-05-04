package Cricbuzz;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.Manager.GameManager;
import Cricbuzz.factory.PlayerTypeFactory;
import Cricbuzz.match.MatchType;
import Cricbuzz.players.Player;
import Cricbuzz.players.PlayerType;


public class Main {
    static PlayerTypeFactory factory = new PlayerTypeFactory();
    public static void main(String[] args) {
        List<Player> battingPlayerList = getBattingList();
        List<Player> bowlingPlayerList = getBowlingList();

        GameManager manager = new GameManager("India", battingPlayerList, "Sheru", bowlingPlayerList);
        manager.setMatchType(MatchType.T20);
        manager.startGame();
    }

    private static List<Player> getBattingList() {
        List<Player> list = new ArrayList<>();
        list.add(factory.getPlayerByType(PlayerType.BATSMAN, "Rohit Sharma", 1));
        list.add(factory.getPlayerByType(PlayerType.BATSMAN, "Subhman Gill", 2));
        list.add(factory.getPlayerByType(PlayerType.BATSMAN, "Virat Kohli", 3));
        list.add(factory.getPlayerByType(PlayerType.BATSMAN, "Rishab Pant", 4));
        list.add(factory.getPlayerByType(PlayerType.BATSMAN, "Shreyas Iyer",5));
        return list;
    }

    private static List<Player> getBowlingList() {
        List<Player> list = new ArrayList<>();
        list.add(factory.getPlayerByType(PlayerType.BOWLER, "Sonu", 6));
        list.add(factory.getPlayerByType(PlayerType.BOWLER, "Monu", 7));
        list.add(factory.getPlayerByType(PlayerType.BOWLER, "Tonu", 8));
        list.add(factory.getPlayerByType(PlayerType.BOWLER, "Jonu", 9));
        list.add(factory.getPlayerByType(PlayerType.BOWLER, "Gonu",10));
        return list;
    }
}
