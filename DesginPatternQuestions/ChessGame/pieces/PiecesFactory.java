package ChessGame.pieces;

import ChessGame.pieces.chessPieces.Bishop;
import ChessGame.pieces.chessPieces.Rook;
import ChessGame.pieces.chessPieces.King;
import ChessGame.pieces.chessPieces.Knight;
import ChessGame.pieces.chessPieces.Pawn;
import ChessGame.pieces.chessPieces.Queen;

public class PiecesFactory {
    public MovementStrategy getPiecesFactory(String piece) {
        switch (piece) {
            case "king": return new King();
            case "queen": return new Queen();
            case "rook": return new Rook();
            case "bishop": return new Bishop();
            case "knight": return new Knight();
            case "pawn": return new Pawn();
        }
        return null;
    }
}
