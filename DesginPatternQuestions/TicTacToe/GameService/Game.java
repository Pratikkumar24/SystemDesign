package SystemDesign.DesginPatternQuestions.TicTacToe.GameService;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import SystemDesign.DesginPatternQuestions.TicTacToe.Board.BoardGame;
import SystemDesign.DesginPatternQuestions.TicTacToe.Enum.GameState;
import SystemDesign.DesginPatternQuestions.TicTacToe.Enum.PieceType;
import SystemDesign.DesginPatternQuestions.TicTacToe.Pieces.Piece;
import SystemDesign.DesginPatternQuestions.TicTacToe.Players.Player;

public class Game {
    Deque<Player> players;
    BoardGame board;
    int totalPlayers;
    HashSet<PieceType> setOfPieces;

    public Game(int size, int totalPlayers) {
        board = new BoardGame(size);
        players = new LinkedList<>();
        this.totalPlayers = totalPlayers;
        setOfPieces = new HashSet<>();
    }

    public void intializePlayers() {
        Scanner scanner = new Scanner(System.in);

        while(totalPlayers>0) {
            System.out.println("Enter name and pieceType(X|O)");
            String name = scanner.nextLine();
            String pieceType = scanner.nextLine();

            PieceType piece = pieceType.equalsIgnoreCase("X") ? PieceType.X:PieceType.O;
            if (setOfPieces.contains(piece)) {
                System.out.println("This piece is already taken..Please take another");
                continue;
            } else {
                setOfPieces.add(piece);
            }

            Piece p = new Piece(piece);
            Player player = new Player(name, p);
            players.addFirst(player);
            totalPlayers--;
        }
        scanner.close();
        
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        //Printing the board
        board.printBoard();
        System.out.println();
        try {
            while(true) {
                Player player = players.removeFirst();
                System.out.print(player.getPlayerName()+", Please make you move (input-> row and col):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Piece piece = player.getPieceType();
    
                // Addding the piece in the board
                boolean isPlaceable = board.addPiece(row, col, piece);
    
                if(isPlaceable == false) {
                    System.out.println("This place is already full..");
                    players.addFirst(player);
                    continue;
                }
    
                System.out.println();
                board.printBoard();
                System.out.println();

                //Check the game state
                GameState currentState = board.checkGameState(player);
                if(currentState == GameState.WIN) {
                    scanner.close();
                    System.out.println("Congratulations!!.. "+player.getPlayerName()+" has WON");
                    return;
                }
                if(currentState == GameState.DRAW) {
                    scanner.close();
                    System.out.println("..Match Draw!!");
                    return;
                }
                
                players.addLast(player);
            }
        } finally {
            scanner.close();
        }
       
    }
}
