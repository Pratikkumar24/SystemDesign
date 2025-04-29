package ChessGame.pieces;

import ChessGame.board.Board;
import ChessGame.type.ChessPiece;
import ChessGame.type.PieceType;

public class Pieces {
    PieceType pieceType;
    ChessPiece chessPiece;
    MovementStrategy movementStrategy;

    public Pieces(PieceType pieceType, ChessPiece chessPiece, MovementStrategy movementStrategy) {
        this.pieceType = pieceType;
        this.chessPiece = chessPiece;
        this.movementStrategy = movementStrategy;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public ChessPiece getChessPiece() {
        return chessPiece;
    }
    public Boolean canMove(Board board, int row, int col) {
        return movementStrategy.canMove(board, row, col);
    }
}
