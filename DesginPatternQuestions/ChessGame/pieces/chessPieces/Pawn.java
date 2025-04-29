package ChessGame.pieces.chessPieces;

import ChessGame.board.Board;
import ChessGame.pieces.MovementStrategy;

public class Pawn implements MovementStrategy{

    @Override
    public Boolean canMove(Board board, int row, int col) {
        /** TODO : Implement the move */
        return true;
    }
    
}
