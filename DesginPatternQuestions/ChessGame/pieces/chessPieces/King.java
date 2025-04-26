package pieces.chessPieces;


import board.Board;
import pieces.MovementStrategy;

public class King implements MovementStrategy{

    @Override
    public Boolean canMove(Board board, int row, int col) {
        /** TODO : Implement the move */
        return true;
    }
    
}
