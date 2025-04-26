package player;

import board.Board;
import type.PieceType;

public class Player {
    private final String name;
    private final PieceType pieceType;
    private final PlayerStrategy playerStrategy;

    public Player(String name, PieceType pieceType, PlayerStrategy strategy) {
        this.name = name;
        this.pieceType = pieceType;
        this.playerStrategy = strategy;
    }

    public String getName() {
        return name;
    }

    public PieceType getPieceType() {
        return pieceType;
    }


    public void selectMove(Board board) {
        playerStrategy.selectMove(board);
    }
}
