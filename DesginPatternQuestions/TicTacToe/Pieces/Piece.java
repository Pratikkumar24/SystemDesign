package SystemDesign.DesginPatternQuestions.TicTacToe.Pieces;

import SystemDesign.DesginPatternQuestions.TicTacToe.Enum.PieceType;

public class Piece {
    
    private PieceType pieceType;

    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public Character getPieceType() {
        return pieceType == PieceType.X ? 'X' : 'O';
    }
}
