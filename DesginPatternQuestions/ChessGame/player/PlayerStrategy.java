package ChessGame.player;

import ChessGame.board.Board;

public interface PlayerStrategy {
    public void selectMove(Board board);
}
