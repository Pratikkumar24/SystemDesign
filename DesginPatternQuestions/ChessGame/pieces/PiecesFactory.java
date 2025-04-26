package pieces;

import pieces.chessPieces.Bishop;
import pieces.chessPieces.Rook;
import pieces.chessPieces.King;
import pieces.chessPieces.Knight;
import pieces.chessPieces.Pawn;
import pieces.chessPieces.Queen;

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
