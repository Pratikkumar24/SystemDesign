package TicTacToe;

import java.util.Scanner;
import TicTacToe.GameService.Game;

public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE GAME");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the board game and total players:");
        int size = scanner.nextInt();
        int totalPlayers = scanner.nextInt();
        Game game = new Game(size, totalPlayers);
        System.out.println("Enter the player details");
        game.intializePlayers();
        game.startGame();
        scanner.close();
    }
}
