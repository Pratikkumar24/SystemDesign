package Cricbuzz.Manager;

import java.util.List;

import Cricbuzz.controller.MatchController;
import Cricbuzz.match.Match;
import Cricbuzz.match.MatchInning;
import Cricbuzz.match.MatchType;
import Cricbuzz.players.Batsman;
import Cricbuzz.players.Bowler;
import Cricbuzz.players.Player;
import Cricbuzz.players.PlayerStatus;
import Cricbuzz.scoreboard.ScoreBoard;
import Cricbuzz.team.BattingTeam;
import Cricbuzz.team.BowlingTeam;
import Cricbuzz.team.TeamStatus;

public class GameManager {
    
    private Match match = Match.getInstance();
    private List<Player> battingTeamPlayers;
    private List<Player> bowlingTeamPlayers;
    private MatchController controller;
    private BattingTeam battingTeam;
    private BowlingTeam bowlingTeam;

    public GameManager(String teamName1, List<Player> battingTeamPlayer, String teamName2, List<Player> bowlingTeamPlayer) {
        match.setMatchInning(MatchInning.FIRST_INNING);

        this.battingTeamPlayers = battingTeamPlayer;
        this.bowlingTeamPlayers = bowlingTeamPlayer;

        battingTeam = new BattingTeam(TeamStatus.ACTIVE, teamName1);
        bowlingTeam = new BowlingTeam(TeamStatus.ACTIVE, teamName2);

        battingTeam.addPlayer(battingTeamPlayer);
        bowlingTeam.addPlayer(bowlingTeamPlayer);

        Batsman striker = (Batsman) battingTeamPlayer.get(0);
        striker.setPlayerStatus(PlayerStatus.ACTIVE);

        Batsman nonStriker = (Batsman) battingTeamPlayer.get(1);
        nonStriker.setPlayerStatus(PlayerStatus.ACTIVE);

        battingTeam.setStriker(striker);
        battingTeam.setNonStriker(nonStriker);

        Bowler bowler = (Bowler) bowlingTeamPlayer.get(bowlingTeamPlayer.size()-1);
        
        bowlingTeam.setCurrentBowler(bowler);

        ScoreBoard scoreBoard = new ScoreBoard(battingTeam, bowlingTeam);
        
        match.updateScoreBoard(scoreBoard); 
        controller = new MatchController();
    }

    public void setMatchType(MatchType type) {
        match.setMatchType(type);
    }

    public void showScore() {
        if (match.getMatchType() == null) {
            System.out.println("Match type is not yet set.. first set that");
        } else {
            match.showScoreCard();
        }
    }

    public void startGame() {
        if (match.getMatchType() == null) {
            System.out.println("Match type is not yet set.. so can't start the game");
        } else {
            System.out.println("---- Starting the game ----");
            controller.setTeams(battingTeam, bowlingTeam);
            controller.startGame();
            inningsCompleted();
            controller.startGame();
        }
    }

    public void inningsCompleted() {
        match.setMatchInning(MatchInning.SECOND_INNING);
        String teamName1 = battingTeam.getTeamName();
        String teamName2 = bowlingTeam.getTeamName();

        battingTeam = new BattingTeam(TeamStatus.ACTIVE, teamName1);
        bowlingTeam = new BowlingTeam(TeamStatus.ACTIVE, teamName2);

        battingTeam.addPlayer(bowlingTeamPlayers);
        bowlingTeam.addPlayer(battingTeamPlayers);

        ScoreBoard scoreBoard = new ScoreBoard(battingTeam, bowlingTeam);
        match.updateScoreBoard(scoreBoard); 
        controller.setTeams(battingTeam, bowlingTeam);
    }
}
