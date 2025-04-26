package pieces;

import board.Board;

public interface MovementStrategy {
    Boolean canMove(Board board, int row, int col);
}
