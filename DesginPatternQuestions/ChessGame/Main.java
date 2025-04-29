package ChessGame;

import ChessGame.board.Board;
import ChessGame.player.Player;
import ChessGame.player.PlayerFactory;
import ChessGame.type.PieceType;

public class Main {
    public static void main(String[] args) {
        PlayerFactory factory = new PlayerFactory();
        Player player1 = new Player("user1",PieceType.WHITE_PIECE, factory.getPlayerStrategy("human"));
        Player player2 = new Player("user2",PieceType.BLACK_PIECE, factory.getPlayerStrategy("human"));
        Board board = new Board(player1, player2);
        board.startGame();
    }
}
