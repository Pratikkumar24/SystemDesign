package Cricbuzz.controller;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Cricbuzz.factory.MatchTypeOverFactory;
import Cricbuzz.match.Match;
import Cricbuzz.match.MatchInning;
import Cricbuzz.players.Batsman;
import Cricbuzz.players.Bowler;
import Cricbuzz.players.PlayerStatus;
import Cricbuzz.team.BattingTeam;
import Cricbuzz.team.BowlingTeam;
import Cricbuzz.team.TeamStatus;

/**
 * Responsiblity
 * 1) Simulates the game
 * 2) has a random generator which generates a number from (-1 to 6)
 * where the -1 says the the wicket.
 * 3) once a over is done, then a selection of new bowler is made randomly
 * 4) once a wicket has happend, then a selection 
 * of new batsman is made randomly
 */
public class MatchController {
    
    private Match currMatch = Match.getInstance();
    private Random random = new Random();
    private MatchTypeOverFactory factory;
    private BattingTeam battingTeam;
    private BowlingTeam bowlingTeam;

    public MatchController() {
        factory = new MatchTypeOverFactory();
    }

    public void setTeams(BattingTeam battingTeam, BowlingTeam bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
    }

    private int getRandomRun() {
        return random.nextInt(8) - 1; // Generates number from -1 to 6
    }

    public void startGame() {
        int totalOvers = factory.getNumberOfOversByType(currMatch.getMatchType());
        Scanner scanner = new Scanner(System.in);
        for(int over = 0; over<totalOvers; over++) {
            startOver();
            updateNextBowler(bowlingTeam.getCurrentBowler());
            
            System.out.print("Do you want to see the score board (1/0): ");
            int input = scanner.nextInt();
            System.out.println();
            switch (input) {
                case 1:
                    currMatch.showScoreCard();
                    break;
                default:
                    break;
            }
        }
        /** Update the teams total score */
        currMatch.setTargetScore(battingTeam.getTotalRunsScored());

        if (currMatch.getMatchInning() == MatchInning.SECOND_INNING) {
            battingTeam.setTeamStatus(TeamStatus.LOOSE);
            bowlingTeam.setTeamStatus(TeamStatus.WIN);
            System.out.println("--- MATCH IS OVER (BOWLING TEAM HAS WON) ---");
        } else {
            System.out.println("Target given by the "+battingTeam.getTeamName()+" -> "+ currMatch.getTargetScore());
        }

        scanner.close();
    }

    private void updateNextBowler(Bowler bowler) {
        bowler.setBowlingStatus(PlayerStatus.CANT_BOWL);

        for(Bowler newBowler: bowlingTeam.getListOfBowlers()) {
            if (newBowler.getBowlingStatus() == PlayerStatus.YET_TO_BOWL) {
                bowlingTeam.setCurrentBowler(newBowler);
                return;
            }
        }
    }

    private void startOver() {
        Batsman striker = battingTeam.getStriker();
        Batsman nonStriker = battingTeam.getNonStriker();
        Bowler bowler = bowlingTeam.getCurrentBowler();

        for(int i=0; i<6; i++) {
            int run = getRandomRun();
            if (run == -1) {
                bowler.addWickets();
                bowlingTeam.addTeamWicket();
                striker.setPlayerStatus(PlayerStatus.OUT);
                striker = getNewStriker(); //Getting new striker
                if (striker == null) {
                    System.out.println("---MATCH IS OVER AS ALL PLAYERS ARE OUT---");
                    return;
                }
            } else {
                striker.addRuns(run);
                if (run%2 == 1) {
                    Batsman temp = striker;
                    striker = nonStriker;
                    nonStriker = temp;
                }
            }

            if (currMatch.getMatchInning() == MatchInning.SECOND_INNING && battingTeam.getTotalRunsScored() > currMatch.getTargetScore()) {
                battingTeam.setTeamStatus(TeamStatus.WIN);
                bowlingTeam.setTeamStatus(TeamStatus.LOOSE);
                System.out.println("---MATCH IS OVER (Batting Team has WON) ---");
                return;
            }
        }
        /** Swapping the striker and non-striker */
        Batsman temp = striker;
        striker = nonStriker;
        nonStriker = temp;
    }

    private Batsman getNewStriker() {
        List<Batsman> batsmansList = battingTeam.getListOfBatsmans();
        for(Batsman batsman: batsmansList) {
            if (batsman.getPlayerStatus() == PlayerStatus.NOT_OUT) {
                batsman.setPlayerStatus(PlayerStatus.ACTIVE);
                return batsman;
            }
        }

        return null;
    }
}
